const API_URL = "http://localhost:8081/contato";
async function carregarContatos() {
  const resposta = await fetch(API_URL);
  const contatos = await resposta.json();
  const lista = document.getElementById("lista");
  lista.innerHTML = "";
  contatos.forEach((contato) => {
    const linha = document.createElement("tr");
    linha.innerHTML = `
 <td>${contato.nome}</td>
 <td>${contato.email}</td>
 <td>${contato.telefone}</td>
 <td>
 <button onclick="prepararEdicao(${contato.id}, '${contato.nome}', '${contato.email}',
'${contato.telefone}')">
 Editar
 </button>
 <button onclick="excluirContato(${contato.id})">
 Excluir
 </button>
 </td>
 `;
    lista.appendChild(linha);
  });
}
function validarFrontend(nome, email, telefone) {
  if (!nome) {
    alert("Informe o nome.");
    return false;
  }
  if (!email) {
    alert("Informe o email.");
    return false;
  }
  if (!email.includes("@")) {
    alert("Informe um email válido.");
    return false;
  }
  if (!telefone) {
    alert("Informe o telefone.");
    return false;
  }
  return true;
}
async function salvar() {
  const id = document.getElementById("id").value;
  const nome = document.getElementById("nome").value.trim();
  const email = document.getElementById("email").value.trim();
  const telefone = document.getElementById("telefone").value.trim();
  if (!validarFrontend(nome, email, telefone)) {
    return;
  }
  const contato = { nome, email, telefone };
  let resposta;
  if (id) {
    resposta = await fetch(`${API_URL}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(contato),
    });
  } else {
    resposta = await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(contato),
    });
  }
  if (!resposta.ok) {
    const erro = await resposta.json();
    alert(erro.erro || "Erro ao salvar contato.");
    return;
  }
  limparFormulario();
  carregarContatos();
}
function prepararEdicao(id, nome, email, telefone) {
  document.getElementById("id").value = id;
  document.getElementById("nome").value = nome;
  document.getElementById("email").value = email;
  document.getElementById("telefone").value = telefone;
}
async function excluirContato(id) {
  const confirma = confirm("Deseja excluir este contato?");
  if (!confirma) {
    return;
  }
  const resposta = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });
  if (!resposta.ok) {
    const erro = await resposta.json();
    alert(erro.erro || "Erro ao excluir contato.");
    return;
  }
  carregarContatos();
}
function limparFormulario() {
  document.getElementById("id").value = "";
  document.getElementById("nome").value = "";
  document.getElementById("email").value = "";
  document.getElementById("telefone").value = "";
}
carregarContatos();

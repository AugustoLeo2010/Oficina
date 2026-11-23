const API = "/api";

const entities = {
    clients: {
        name: "Cliente",
        fields: [
            ["name", "Nome", "text"],
            ["cpf", "CPF", "text"],
            ["numberPhone", "Telefone", "text"],
            ["email", "E-mail", "email"]
        ]
    },

    employees: {
        name: "Funcionário",
        fields: [
            ["name", "Nome", "text"],
            ["wage", "Salário", "number"],
            ["cpf", "CPF", "text"],
            ["numberPhone", "Telefone", "text"],
            ["email", "E-mail", "email"]
        ]
    },

    vehicles: {
        name: "Veículo",
        fields: [
            ["model", "Modelo", "text"],
            ["mark", "Marca", "text"],
            ["color", "Cor", "text"],
            ["year", "Ano", "text"],
            ["type", "Tipo", "text"],
            ["kmr", "Quilometragem", "number"]
        ]
    },

    services: {
        name: "Serviço",
        fields: [
            ["name", "Nome", "text"],
            ["type", "Tipo", "text"],
            ["value", "Preço", "number"],
            ["description", "Descrição", "text"]
        ]
    },

    appointments: {
        name: "Agendamento",
        fields: [
            ["name", "Nome do cliente", "text"],
            ["date", "Data", "date"],
            ["numberPhone", "Telefone", "text"],
            ["hours", "Horário", "time"]
        ]
    }
};

const entitySelect = document.getElementById("entitySelect");
const form = document.getElementById("recordForm");
const formFields = document.getElementById("formFields");
const tableHead = document.getElementById("tableHead");
const tableBody = document.getElementById("tableBody");
const statusBox = document.getElementById("status");

let currentEntity = "clients";
let editingId = null;

function showStatus(message, type = "success") {
    statusBox.textContent = message;
    statusBox.className = type;
}

function renderForm() {
    const config = entities[currentEntity];

    document.getElementById("formTitle").textContent =
        editingId ? `Editar ${config.name}` : `Cadastrar ${config.name}`;

    document.getElementById("saveButton").textContent =
        editingId ? "Salvar alterações" : "Cadastrar";

    document.getElementById("cancelButton").classList.toggle(
        "hidden", !editingId
    );

    formFields.innerHTML = "";

    config.fields.forEach(([key, label, type]) => {
        const div = document.createElement("div");
        div.className = "field";

        const labelElement = document.createElement("label");
        labelElement.textContent = label;

        const input = document.createElement("input");
        input.type = type;
        input.name = key;
        input.required = true;
        input.step = type === "number" ? "any" : "";

        div.appendChild(labelElement);
        div.appendChild(input);

        formFields.appendChild(div);
    });
}

async function loadRecords() {
    try {
        const response = await fetch(`${API}/${currentEntity}`);

        if (!response.ok) {
            throw new Error("Não foi possível carregar os registros.");
        }

        const records = await response.json();

        renderTable(records);

    } catch (error) {
        showStatus(error.message, "error");
    }
}

function renderTable(records) {
    const config = entities[currentEntity];

    document.getElementById("tableTitle").textContent =
        `${config.name}s cadastrados`;

    tableHead.innerHTML = "";
    tableBody.innerHTML = "";

    const header = document.createElement("tr");

    const columns = ["ID", ...config.fields.map(field => field[1]), "Ações"];

    columns.forEach(column => {
        const th = document.createElement("th");
        th.textContent = column;
        header.appendChild(th);
    });

    tableHead.appendChild(header);

    if (records.length === 0) {
        const row = document.createElement("tr");
        const cell = document.createElement("td");

        cell.colSpan = columns.length;
        cell.textContent = "Nenhum registro encontrado.";

        row.appendChild(cell);
        tableBody.appendChild(row);
        return;
    }

    records.forEach(record => {
        const row = document.createElement("tr");

        const idCell = document.createElement("td");
        idCell.textContent = record.id;
        row.appendChild(idCell);

        config.fields.forEach(([key]) => {
            const cell = document.createElement("td");
            cell.textContent = record[key] ?? "-";
            row.appendChild(cell);
        });

        const actionsCell = document.createElement("td");
        actionsCell.className = "actions";

        const editButton = document.createElement("button");
        editButton.textContent = "Editar";
        editButton.className = "edit";
        editButton.addEventListener("click", () => editRecord(record));

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Excluir";
        deleteButton.className = "delete";
        deleteButton.addEventListener("click", () => deleteRecord(record.id));

        actionsCell.append(editButton, deleteButton);
        row.appendChild(actionsCell);

        tableBody.appendChild(row);
    });
}

form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const data = {};

    entities[currentEntity].fields.forEach(([key]) => {
        const input = form.elements[key];
        data[key] = input.value;

        if (input.type === "number") {
            data[key] = Number(input.value);
        }
    });

    const url = editingId
        ? `${API}/${currentEntity}/${editingId}`
        : `${API}/${currentEntity}`;

    const method = editingId ? "PUT" : "POST";

    try {
        const response = await fetch(url, {
            method: method,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            const message = await response.text();
            throw new Error(message || "Erro ao salvar registro.");
        }

        showStatus(
            editingId ? "Registro atualizado!" : "Registro cadastrado!"
        );

        resetForm();
        await loadRecords();

    } catch (error) {
        showStatus(error.message, "error");
    }
});

function editRecord(record) {
    editingId = record.id;

    renderForm();

    entities[currentEntity].fields.forEach(([key]) => {
        form.elements[key].value = record[key] ?? "";
    });

    window.scrollTo({ top: 0, behavior: "smooth" });
}

async function deleteRecord(id) {
    if (!confirm("Deseja realmente excluir este registro?")) {
        return;
    }

    try {
        const response = await fetch(
            `${API}/${currentEntity}/${id}`,
            { method: "DELETE" }
        );

        if (!response.ok) {
            throw new Error("Não foi possível excluir o registro.");
        }

        showStatus("Registro excluído com sucesso!");
        await loadRecords();

    } catch (error) {
        showStatus(error.message, "error");
    }
}

function resetForm() {
    editingId = null;
    form.reset();
    renderForm();
}

entitySelect.addEventListener("change", () => {
    currentEntity = entitySelect.value;
    resetForm();
    loadRecords();
});

document.getElementById("cancelButton").addEventListener("click", resetForm);

document.getElementById("refreshButton").addEventListener("click", loadRecords);

renderForm();
loadRecords();
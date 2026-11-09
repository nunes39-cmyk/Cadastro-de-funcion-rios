# 👨‍💼 Sistema de Cadastro de Funcionários em Java

![Java](https://img.shields.io/badge/Java-POO-orange)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)
![Projeto](https://img.shields.io/badge/Projeto-Acadêmico-blue)
![Interface](https://img.shields.io/badge/Interface-Terminal-informational)

## 📖 Sobre o projeto

Este projeto consiste em um **sistema de cadastro de funcionários desenvolvido em Java**, com o objetivo de aplicar conceitos fundamentais da **Programação Orientada a Objetos (POO)**.

O programa permite cadastrar dois tipos de funcionários: **Professor** e **Administrativo**, utilizando herança, encapsulamento, métodos e validação de dados.

Cada categoria possui informações específicas e cálculos próprios, demonstrando como diferentes classes podem compartilhar características de uma classe principal.

O sistema foi desenvolvido como atividade acadêmica do curso de **Análise e Desenvolvimento de Sistemas da Faculdade Anhanguera**.

## ⚙️ Funcionalidades

- Cadastro de professores e funcionários administrativos.
- Menu interativo para selecionar o tipo de funcionário.
- Entrada de dados pelo terminal.
- Armazenamento de nome, CPF e salário em objetos.
- Validação de CPF com exatamente 11 dígitos numéricos.
- Formatação do CPF no padrão `000.000.000-00`.
- Validação de salários positivos.
- Aceitação de diferentes formatos de entrada salarial, incluindo `2500` e `2.500,00`.
- Formatação monetária no padrão brasileiro (R$).
- Seleção da titulação acadêmica dos professores.
- Cadastro da quantidade de dependentes dos funcionários administrativos.
- Cálculo de imposto de renda dos professores.
- Cálculo de contribuição sindical dos funcionários administrativos.
- Mensagens de erro e repetição da entrada quando um dado inválido é informado.

## 🧩 Estrutura do sistema

### Classe `Funcionario`

Representa a classe principal do sistema.

Possui os atributos privados:

- `nome`
- `cpf`
- `salario`

Esses atributos são acessados por métodos getters e setters, aplicando o conceito de **encapsulamento**.

### Classe `Professor`

Herda as características da classe `Funcionario` por meio de `extends`.

Além dos dados básicos, possui:

- Atributo `titulacao`.
- Métodos para consultar e alterar a titulação.
- Método `getImpostoRenda()`, responsável por calcular 23% do salário.

**Exemplo de cálculo:**

Salário: R$ 3.000,00

Imposto calculado: R$ 690,00

### Classe `Administrativo`

Também herda as características da classe `Funcionario`.

Possui:

- Atributo `dependentes`.
- Métodos para consultar e alterar a quantidade de dependentes.
- Método `getContribuicaoSindical()`, responsável por calcular 1% do salário.

**Exemplo de cálculo:**

Salário: R$ 3.000,00

Contribuição sindical calculada: R$ 30,00

### Classe `Main`

Responsável pela execução do programa, interação com o usuário e validação das informações inseridas.

Utiliza a classe `Scanner` para receber os dados e `NumberFormat` para apresentar valores monetários no padrão brasileiro.

## 🖥️ Funcionamento do programa

Ao iniciar, o sistema apresenta um menu:

```text
===== MENU DE FUNCIONARIOS =====
Digite apenas uma das letras abaixo:
P - Professor
A - Administrativo
Escolha (P ou A):
```

O usuário deve selecionar uma das opções disponíveis.

### 👨‍🏫 Cadastro de professor

Ao selecionar `P`, o sistema solicita:

1. Nome.
2. CPF.
3. Salário.
4. Titulação acadêmica.

As titulações disponíveis são:

| Opção | Titulação |
|---|---|
| G | Graduação |
| E | Especialização |
| M | Mestrado |
| D | Doutorado |
| P | Pós-doutorado |

Após o preenchimento, o sistema apresenta as informações cadastradas e o imposto calculado.

**Exemplo ilustrativo de resultado:**

```text
--- PROFESSOR ---
Nome: João Silva
CPF: 123.456.789-01
Salario: R$ 3.000,00
Titulacao: Mestrado
Imposto: R$ 690,00
```

### 👩‍💼 Cadastro de administrativo

Ao selecionar `A`, o sistema solicita:

1. Nome.
2. CPF.
3. Salário.
4. Quantidade de dependentes.

Após o preenchimento, apresenta as informações cadastradas e a contribuição sindical calculada.

**Exemplo ilustrativo de resultado:**

```text
--- ADMINISTRATIVO ---
Nome: Maria Oliveira
CPF: 123.456.789-01
Salario: R$ 2.500,00
Dependentes: 2
Contribuicao sindical: R$ 25,00
```

## 🛡️ Validação de dados

O sistema possui mecanismos de validação para evitar entradas incorretas.

| Campo | Regra aplicada |
|---|---|
| Tipo de funcionário | Aceita somente P ou A |
| CPF | Exige exatamente 11 números |
| Salário | Exige valor numérico positivo |
| Dependentes | Aceita somente números inteiros iguais ou superiores a zero |
| Titulação | Aceita somente G, E, M, D ou P |

Quando o usuário informa um valor inválido, o programa apresenta uma mensagem explicativa e solicita uma nova entrada.

**Observação:** a validação do CPF verifica a quantidade e o formato dos dígitos, mas não realiza a verificação matemática dos dígitos verificadores de um CPF real.

## 🧠 Conceitos de programação aplicados

| Conceito | Aplicação |
|---|---|
| Classes e objetos | Representação dos funcionários |
| Encapsulamento | Atributos privados e métodos getters/setters |
| Herança | `Professor` e `Administrativo` herdam de `Funcionario` |
| Métodos | Operações de cadastro, consulta e cálculos |
| Estruturas condicionais | Seleção do tipo de funcionário |
| Estruturas de repetição | Nova solicitação após entradas inválidas |
| Tratamento de exceções | Tratamento de valores numéricos incorretos |
| Expressões regulares | Verificação do formato dos dados |
| Formatação monetária | Apresentação de valores em reais |

## 🚀 Como executar

**Pré-requisito:** Java JDK instalado.

1. Clone ou baixe este repositório.
2. Certifique-se de que o arquivo principal esteja nomeado como `Main.java`.
3. Abra o terminal na pasta do projeto.
4. Compile o código:

```bash
javac Main.java
```

5. Execute o programa:

```bash
java Main
```

Também é possível utilizar compiladores online, como o **OnlineGDB**, selecionando a linguagem Java.

## 📌 Limitações do projeto

Este sistema foi desenvolvido para fins acadêmicos.

- Funciona por meio do terminal.
- Não possui interface gráfica.
- Não utiliza banco de dados.
- Não mantém os cadastros após o encerramento.
- Realiza o cadastro de um funcionário por execução.
- Os percentuais de imposto e contribuição são valores fixos definidos pelo exercício, não constituindo um cálculo tributário oficial.

## 📚 Objetivo acadêmico

Atividade da **Unidade 03 — Seção 02**, desenvolvida para praticar herança e encapsulamento na linguagem Java.

O objetivo é implementar uma classe principal `Funcionario` e duas subclasses, `Professor` e `Administrativo`, cada uma com seus próprios atributos e métodos de cálculo.

## 👨‍💻 Autor

**Miguel Nunes Ribeiro**

Estudante de Análise e Desenvolvimento de Sistemas.

GitHub: [@nunes39-cmyk](https://github.com/nunes39-cmyk)

---

⭐ Projeto desenvolvido para fins de estudo, prática de Programação Orientada a Objetos e aprimoramento de habilidades em Java.


import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.math.BigDecimal;

class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}

class Professor extends Funcionario {
    private String titulacao;

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public double getImpostoRenda() {
        return getSalario() * 0.23;
    }
}

class Administrativo extends Funcionario {
    private int dependentes;

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public int getDependentes() {
        return dependentes;
    }

    public double getContribuicaoSindical() {
        return getSalario() * 0.01;
    }
}

public class Main {

    public static String lerCpf(Scanner entrada) {
        while (true) {
            System.out.print("CPF (apenas 11 numeros): ");
            String cpf = entrada.nextLine().trim();

            if (cpf.matches("[0-9]{11}")) {
                return cpf;
            }

            System.out.println("\nCPF invalido!");
            System.out.println(
                "Digite exatamente 11 numeros, sem pontos ou traco."
            );
            System.out.println("Tente novamente.\n");
        }
    }

    public static String formatarCpf(String cpf) {
        return cpf.substring(0, 3) + "."
             + cpf.substring(3, 6) + "."
             + cpf.substring(6, 9) + "-"
             + cpf.substring(9, 11);
    }

    public static double converterSalario(String texto) {
        texto = texto.trim()
                     .replace("R$", "")
                     .replace(" ", "");

        if (texto.matches("[0-9]{1,3}(\\.[0-9]{3})+(,[0-9]{1,2})?")) {
            texto = texto.replace(".", "").replace(",", ".");
        } else if (texto.matches("[0-9]+,[0-9]{1,2}")) {
            texto = texto.replace(",", ".");
        } else if (!texto.matches("[0-9]+(\\.[0-9]{1,2})?")) {
            throw new NumberFormatException("Formato invalido");
        }

        BigDecimal valor = new BigDecimal(texto);

        if (valor.signum() <= 0 ||
            valor.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0) {
            throw new NumberFormatException("Valor invalido");
        }

        double salario = valor.doubleValue();

        if (!Double.isFinite(salario)) {
            throw new NumberFormatException("Valor invalido");
        }

        return salario;
    }

    public static double lerSalario(Scanner entrada) {
        while (true) {
            System.out.print("Salario: ");
            String texto = entrada.nextLine();

            try {
                return converterSalario(texto);
            } catch (NumberFormatException erro) {
                System.out.println("\nSalario invalido!");
                System.out.println(
                    "Digite um valor positivo, por exemplo: 2500 ou 2.500,00."
                );
                System.out.println("Tente novamente.\n");
            }
        }
    }

    public static int lerDependentes(Scanner entrada) {
        while (true) {
            System.out.print("Dependentes (quantidade): ");
            String texto = entrada.nextLine().trim();

            if (texto.matches("[0-9]+")) {
                try {
                    return Integer.parseInt(texto);
                } catch (NumberFormatException erro) {
                    // Numero acima do limite permitido.
                }
            }

            System.out.println("\nQuantidade de dependentes invalida!");
            System.out.println(
                "Digite um numero inteiro igual ou maior que zero."
            );
            System.out.println("Tente novamente.\n");
        }
    }

    public static String escolherFuncionario(Scanner entrada) {
        while (true) {
            System.out.println("\n===== MENU DE FUNCIONARIOS =====");
            System.out.println("Digite apenas uma das letras abaixo:");
            System.out.println("P - Professor");
            System.out.println("A - Administrativo");
            System.out.print("Escolha (P ou A): ");

            String opcao = entrada.nextLine().trim();

            if (opcao.equalsIgnoreCase("P")
                    || opcao.equalsIgnoreCase("A")) {
                return opcao.toUpperCase(Locale.ROOT);
            }

            System.out.println("\nOpcao invalida!");
            System.out.println("Digite somente P ou A.");
            System.out.println("Tente novamente.");
        }
    }

    // Exige exatamente uma titulacao da lista.
    public static String escolherTitulacao(Scanner entrada) {
        while (true) {
            System.out.println("\n===== TITULACAO DO PROFESSOR =====");
            System.out.println("Escolha apenas uma das letras abaixo:");
            System.out.println("G - Graduacao");
            System.out.println("E - Especializacao");
            System.out.println("M - Mestrado");
            System.out.println("D - Doutorado");
            System.out.println("P - Pos-doutorado");
            System.out.print(
                "Escolha sua titulacao (G, E, M, D ou P): "
            );

            String opcao = entrada.nextLine().trim().toUpperCase(
                Locale.ROOT
            );

            switch (opcao) {
                case "G":
                    return "Graduacao";
                case "E":
                    return "Especializacao";
                case "M":
                    return "Mestrado";
                case "D":
                    return "Doutorado";
                case "P":
                    return "Pos-doutorado";
                default:
                    System.out.println("\nTitulacao invalida!");
                    System.out.println(
                        "Digite somente uma letra: G, E, M, D ou P."
                    );
                    System.out.println("Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        NumberFormat moeda = NumberFormat.getCurrencyInstance(
            Locale.forLanguageTag("pt-BR")
        );

        String opcao = escolherFuncionario(entrada);

        if (opcao.equals("P")) {
            Professor p = new Professor();

            System.out.print("Nome: ");
            p.setNome(entrada.nextLine());

            p.setCpf(lerCpf(entrada));
            p.setSalario(lerSalario(entrada));
            p.setTitulacao(escolherTitulacao(entrada));

            System.out.println("\n--- PROFESSOR ---");
            System.out.println("Nome: " + p.getNome());
            System.out.println("CPF: " + formatarCpf(p.getCpf()));
            System.out.println("Salario: "
                    + moeda.format(p.getSalario()));
            System.out.println("Titulacao: " + p.getTitulacao());
            System.out.println("Imposto: "
                    + moeda.format(p.getImpostoRenda()));

        } else {
            Administrativo a = new Administrativo();

            System.out.print("Nome: ");
            a.setNome(entrada.nextLine());

            a.setCpf(lerCpf(entrada));
            a.setSalario(lerSalario(entrada));
            a.setDependentes(lerDependentes(entrada));

            System.out.println("\n--- ADMINISTRATIVO ---");
            System.out.println("Nome: " + a.getNome());
            System.out.println("CPF: " + formatarCpf(a.getCpf()));
            System.out.println("Salario: "
                    + moeda.format(a.getSalario()));
            System.out.println("Dependentes: "
                    + a.getDependentes());
            System.out.println("Contribuicao sindical: "
                    + moeda.format(a.getContribuicaoSindical()));
        }

        entrada.close();
    }
}

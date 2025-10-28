import java.util.Scanner;

abstract class Operacao {
    private double valor1;
    private double valor2;

    public Operacao(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public double getValor1() {
        return valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public abstract double calcular();
}

class Soma extends Operacao {
    public Soma(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        return getValor1() + getValor2();
    }
}

class Subtracao extends Operacao {
    public Subtracao(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        return getValor1() - getValor2();
    }
}

class Multiplicacao extends Operacao {
    public Multiplicacao(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        return getValor1() * getValor2();
    }
}

class Divisao extends Operacao {
    public Divisao(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        if (getValor2() == 0) {
            throw new ArithmeticException("Divisão por zero!");
        }
        return getValor1() / getValor2();
    }
}

class Potenciacao extends Operacao {
    public Potenciacao(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        return Math.pow(getValor1(), getValor2());
    }
}

class Modulo extends Operacao {
    public Modulo(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        if (getValor2() == 0) {
            throw new ArithmeticException("Módulo por zero!");
        }
        return getValor1() % getValor2();
    }
}

class Media extends Operacao {
    public Media(double valor1, double valor2) {
        super(valor1, valor2);
    }

    public double calcular() {
        return (getValor1() + getValor2()) / 2;
    }
}

class Historico {
    private StringBuilder log = new StringBuilder();

    public void registrar(String tipo, double resultado) {
        log.append(tipo).append(" = ").append(resultado).append("\n");
    }

    public void exibir() {
        System.out.println("=== Histórico de Operações ===");
        System.out.println(log.toString());
    }
}

class Calculadora {
    private Historico historico = new Historico();

    public double executar(Operacao operacao) {
        double resultado = operacao.calcular();
        historico.registrar(operacao.getClass().getSimpleName(), resultado);
        return resultado;
    }

    public void mostrarHistorico() {
        historico.exibir();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        System.out.println("======== CALCULADORA UNIVILLE ========");
        System.out.print("Digite o primeiro valor: ");
        double v1 = sc.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double v2 = sc.nextDouble();

        System.out.println("Escolha sua operação:");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Potenciação");
        System.out.println("6. Módulo");
        System.out.println("7. Média");

        int escolha = sc.nextInt();
        Operacao operacao = null;

        switch (escolha) {
            case 1: operacao = new Soma(v1, v2); break;
            case 2: operacao = new Subtracao(v1, v2); break;
            case 3: operacao = new Multiplicacao(v1, v2); break;
            case 4: operacao = new Divisao(v1, v2); break;
            case 5: operacao = new Potenciacao(v1, v2); break;
            case 6: operacao = new Modulo(v1, v2); break;
            case 7: operacao = new Media(v1, v2); break;
            default:
                System.out.println("Operação inválida!");
                return;
        }

        double resultado = calc.executar(operacao);
        System.out.println("Resultado: " + resultado);
        calc.mostrarHistorico();
    }
}

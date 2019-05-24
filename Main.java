package com.company;
import java.util.Scanner;

public class Main
{

    public static void addEmployee(String[][] myEmployeeText, int number)
    {
        int t = 0, v = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do empregado: ");
        myEmployeeText[t][number] = input.nextLine();
        t++;

        System.out.print("Endereço do empregado: ");
        myEmployeeText[t][number] = input.nextLine();
        t++;

        System.out.println("Escolha um tipo de empregado, dos tipos abaixo");
        System.out.println("hourly");
        System.out.println("salaried");
        System.out.println("commissioned");
        myEmployeeText[t][number] = input.nextLine();
        t++;
        myEmployeeText[t][number] = "mensal";


    }

    public static void removeEmployee(String[][] myEmployeeText, double[][] myEmployeeValue, int[][] dateSales, int[][] payment, int [][]syndicate, int[] numEmployee)
    {
        int numberEm, t = 0, v = 0;
        String clean = " ";
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número do empregado que deseja remover: ");
        numberEm = input.nextInt();
        numEmployee[numberEm] = 0;
        for(t = 0 ; t < 4 ; t++)
        {
            myEmployeeText[t][numberEm] = clean;
        }
        for(v = 0 ; v < 4 ; v++)
        {
            myEmployeeValue[v][numberEm] = 0;
        }
        for(v = 0 ; v < 3 ; v++)
        {
            dateSales[v][numberEm] = 0;
        }
        for(v = 0 ; v < 2 ; v++)
        {
            payment[v][numberEm] = 0;
        }
        for(v = 0 ; v < 6 ; v++)
        {
            syndicate[v][numberEm] = 0;
        }
    }

    public static void alterEmployee(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int[] numEmployee)
    {
        int numberEm, option, t = 0, v = 0;
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número do empregado que deseja alterar: ");
        numberEm = input.nextInt();
        if(numEmployee[numberEm] == 1)
        {
            while(loop)
            {
                System.out.println("ecolha o que deseja alterar:");
                System.out.println("1 - Nome");
                System.out.println("2 - Endereço");
                System.out.println("3 - Tipo");
                System.out.println("4 - terminar as alterações");
                option = input.nextInt();

                switch(option)
                {
                    case 1:
                        System.out.print("Digite o novo Nome: ");
                        myEmployeeText[0][numberEm] = input.nextLine();
                        break;
                    case 2:
                        System.out.print("Digite o novo Endereço: ");
                        myEmployeeText[1][numberEm] = input.nextLine();
                        break;
                    case 3:
                        System.out.print("Digite o novo Tipo: ");
                        myEmployeeText[2][numberEm] = input.nextLine();
                        break;
                    case 4:
                        loop = false;
                        break;

                }
            }
        }
    }

    public static void timeCard(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, double salary, int [] numEmployee)
    {
        int hour, extra, i;
        Scanner input = new Scanner(System.in);
        for(i = 0 ; i < cout ; i++)
        {
            if(numEmployee[i] == 1)
            {
                if("hourly".equals(myEmployeeText[2][i]))
                {
                    System.out.print("Entre com a quantidade de horas trabalhadas:");
                    hour = input.nextInt();
                    if(hour <= 8)
                    {
                        myEmployeeValue[0][i] = salary;
                    }
                    if(hour > 8)
                    {
                        extra = hour - 8;
                        myEmployeeValue[0][i] = salary + (1.5 * extra);
                    }
                }
            }
        }
    }

    public static void resultSales(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, double salary, int [][] sales, int[] numEmployee)
    {
        int i;
        double comission = 0.1;
        Scanner input = new Scanner(System.in);
        for(i = 0 ; i < cout ; i++)
        {
            if(numEmployee[i] == 1)
            {
                if("commissioned".equals(myEmployeeText[2][i]))
                {
                    System.out.println("Entre com a data da venda(da forma dd/mm/aa)");
                    System.out.println("Dia: ");
                    sales[0][i] = input.nextInt();
                    System.out.println("Mês: ");
                    sales[1][i] = input.nextInt();
                    System.out.println("Ano: ");
                    sales[2][i] = input.nextInt();
                    System.out.println("Entre com o valor da venda: ");
                    myEmployeeValue[3][i] += input.nextDouble();
                    myEmployeeValue[2][i] += myEmployeeValue[3][i] * comission;
                }
            }
        }

    }

    public static void paymentShedule(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int [][] payment, int[] numEmployee)
    {
        int i;
        Scanner input = new Scanner(System.in);

        System.out.print("Entre com o número do empregado: ");
        i = input.nextInt();
        if(numEmployee[i] == 1)
        {
            System.out.println("Escolha um dia do mês em que o empregado " + myEmployeeText[0][i] + "irá receber:");
            payment[0][i] = input.nextInt();

            System.out.println("Escolha o método de pagamento para o empregado " + myEmployeeText[0][i] + " :");
            System.out.println("1 - Cheque pelos correios (nenos recomendado)");
            System.out.println("2 - Cheque em mãos");
            System.out.println("3 - Deposito em conta bancária");
            payment[1][i] = input.nextInt();
        }
    }

    public static void newPaymentShedule(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int [][] payment, int[] numEmployee)
    {
        int i, enter;
        String week;
        Scanner input = new Scanner(System.in);

        System.out.print("Entre com o número do empregado: ");
        i = input.nextInt();
        if(numEmployee[i] == 1)
        {
            System.out.println("Escolha uma nova forma em que o empregado " + myEmployeeText[0][i] + "irá receber:");
            System.out.println("1 - mensal escolhendo o dia do mês para ser pago");
            System.out.println("2 - semanal escolhendo o dia da semana para ser pego");
            System.out.println("3 - semanal a cada duas semana para receber ");
            enter = input.nextInt();

            switch (enter)
            {
                case 1:
                    System.out.print("escolha um dia do mês: ");
                    payment[0][i] = input.nextInt();
                    break;

                case 2:
                    myEmployeeText[3][i] = "semanal";
                    System.out.print("escolha um dia da semana (EM EXTENSO, ex.: 'segunda'): ");
                    week = input.nextLine();
                    if("segunda".equals(week))
                        payment[0][i] = 1;
                    if("terça".equals(week))
                        payment[0][i] = 2;
                    if("quarta".equals(week))
                        payment[0][i] = 3;
                    if("quinta".equals(week))
                        payment[0][i] = 4;
                    if("sexta".equals(week))
                        payment[0][i] = 5;
                    break;
                case 3:
                    myEmployeeText[3][i] = "quinzenal";
                    System.out.print("escolha um dia do mês que o empregado irá receber, sabendo que ele será pago 15 dias");
                    payment[0][i] = input.nextInt();
            }
        }


    }
    public static void leafPayment(String[][] myEmployeeText, double[][] myEmployeeValue, int i, int [][] payment, double offSalary)
    {
        double salary;
        if("commissioned".equals(myEmployeeText[2][i]))
        {
            System.out.println("Pagamento do empregado......... " + myEmployeeText[0][i]);
            salary = (myEmployeeValue[1][i]+myEmployeeValue[2][i]+myEmployeeValue[3][i]) - offSalary;
            System.out.println("Valor.......................... " + salary);
            if(payment[1][i] == 1)
                System.out.print("Cheque enviado pelos correios\n\n\n\n\n");

            if(payment[1][i] == 2)
                System.out.print("Cheque entregue em mãos\n\n\n\n\n");

            if(payment[1][i] == 3)
                System.out.print("Depósito feito\n\n\n\n\n");
        }
        if("hourly".equals(myEmployeeText[2][i]))
        {
            System.out.println("Pagamento do empregado......... " + myEmployeeText[0][i]);
            salary = myEmployeeValue[0][i] - offSalary;
            System.out.println("Valor.......................... " + salary);
            if(payment[1][i] == 1)
                System.out.print("Cheque enviado pelos correios\n\n\n\n\n");

            if(payment[1][i] == 3)
                System.out.print("Depósito feito\n\n\n\n\n");

            if(payment[1][i] == 2) {
                System.out.print("Cheque entregue em mãos\n\n\n\n\n");
            }

        }
        else
        {
            System.out.println("Pagamento do empregado......... " + myEmployeeText[0][i]);
            salary = myEmployeeValue[1][i] - offSalary;
            System.out.println("Valor.......................... " + salary);

            if(payment[1][i] == 2) {
                System.out.print("Cheque entregue em mãos\n\n\n\n\n");
            }
            if(payment[1][i] == 1)
                System.out.print("Cheque enviado pelos correios\n\n\n\n\n");

            if(payment[1][i] == 3)
                System.out.print("Depósito feito\n\n\n\n\n");
        }

        myEmployeeValue[0][i] = 0;
        myEmployeeValue[1][i] = 0;
        myEmployeeValue[2][i] = 0;
        myEmployeeValue[3][i] = 0;
    }
    public static void DayPayment(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int[][] payment, int [][]syndicate, int[] numEmployee)
    {
        int i, day;
        double offSalary;
        Scanner input = new Scanner(System.in);
        System.out.println("Entre com a data de hoje (apenas o dia do mês):");
        day = input.nextInt();

            for(i = 0 ; i < cout ; i++)
            {
                if(numEmployee[i] == 1)
                {
                    offSalary = (syndicate[0][i]+syndicate[1][i]+syndicate[2][i]+syndicate[3][i]+syndicate[4][i]+syndicate[5][i])*0.06;
                    if("mensal".equals(myEmployeeText[3][i]))
                    {
                        if(payment[0][i] == day)
                        {
                            leafPayment(myEmployeeText, myEmployeeValue, i, payment,offSalary);
                        }
                    }
                    if("semanal".equals(myEmployeeText[3][i]))
                    {
                        if(day == payment[0][i] || day == (payment[0][i]+7) || day == (payment[0][i]+14) || day == (payment[0][i]+21))
                        {
                            leafPayment(myEmployeeText, myEmployeeValue, i, payment, offSalary);
                        }
                    }
                    if("quinzenal".equals(myEmployeeText[3][i]))
                    {
                        if(day == payment[0][i] || day == payment[0][i]+15)
                        {
                            leafPayment(myEmployeeText, myEmployeeValue, i, payment, offSalary);
                        }
                    }
                }
            }
    }

    public static void serviceCharge(int cout, int[][] syndicate, int[] numEmployee)
    {
        int i, employee, option;
        boolean loop = true;
        Scanner input = new Scanner(System.in);

        System.out.println("Entre com o número do empregado que deseja ser associado ao sindicato:");
        employee = input.nextInt();
        if(numEmployee[employee] == 1)
        {
            while(loop)
            {
                System.out.println("Escolha alguns serviços:");
                System.out.println("1 - assistencia médica");
                System.out.println("2 - assistencia farmacêutica");
                System.out.println("3 - clube esportivo");
                System.out.println("4 - assistencia à martenidade");
                System.out.println("5 - auxílio congresso/conferência");
                System.out.println("6 - bolsa estudo");
                System.out.println("7 - finalizar adição de serviço");
                option = input.nextInt();

                switch(option)
                {
                    case 1:
                        syndicate[0][employee] = 1;
                        break;
                    case 2:
                        syndicate[1][employee] = 1;
                        break;
                    case 3:
                        syndicate[2][employee] = 1;
                        break;
                    case 4:
                        syndicate[3][employee] = 1;
                        break;
                    case 5:
                        syndicate[4][employee] = 1;
                        break;
                    case 6:
                        syndicate[5][employee] = 1;
                        break;
                    case 7:
                        loop = false;
                        break;

                }
            }
        }


    }
    public static void toClearMatriz(int [][] matriz, int i, int j)
    {
        int x, y;
        for(x = 0 ; x < i ; x++)
        {
            for(y = 0 ; y < j ; y++)
            {
                matriz[x][y] = 0;
            }
        }
    }
    public static void printEmployees(String[][] myEmployeeText, int max, int[] numEmployee)
    {
        int i, j;
        for(i = 0 ; i < max ; i++)
        {
            if(numEmployee[i] == 1)
            {
                System.out.println("Nome: " + myEmployeeText[0][i]);
                System.out.println("Endereço: " + myEmployeeText[1][i]);
                System.out.print("Tipo: " + myEmployeeText[2][i] + "\n\n\n");
            }
        }
    }

    public static void main(String[] args)
    {
        int enter, coutEmployee = 0, i = 0;
        int MaxEmployee = 60, MaxAttribut = 7;
        double salary = 998.00;
        boolean loop = true;
        String employeesText[][] = new String[MaxAttribut][MaxEmployee];
        double employeesValue[][] = new double[MaxAttribut][MaxEmployee];
        int dateSales[][] = new int[3][MaxEmployee];
        int payment[][] = new int[2][MaxEmployee];
        int syndicate[][] = new int[6][MaxEmployee];
        int numberEmployee[] = new int[MaxEmployee];
        toClearMatriz(syndicate, 6, MaxEmployee);
        toClearMatriz(payment, 2, MaxEmployee);
        toClearMatriz(dateSales, 3, MaxEmployee);

        for(i = 0 ; i < MaxEmployee ; i++)
            numberEmployee[i] = 0;

        /*
        LINHAS DA MATRIZ EMPLOYEE TEXT
            0 - nome
            1 - endereço
            2 - tipo
        LINHAS DA MATRIZ EMPLOYEE VALUE
            1 - salario horario
            2 - salario mensal
            3 - comissão
            4 - valor da venda
        PARA A VARIÁVEL PAYMENTTYPE CONSIDERE:
            1 - Cheque pelos correios
            2 - Cheque em mãos
            3 - Deposito em conta bancária
        */

        System.out.println("- Sistema de folha de Pagamento -");

        while(loop)
        {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar um empregado");
            System.out.println("2 - Remover um empregado");
            System.out.println("3 - Lançar um cartão de ponto");
            System.out.println("4 - Lançar um resultados de venda");
            System.out.println("5 - Lançar uma taxa de serviço");
            System.out.println("6 - Alterar detalhes do empregado");
            System.out.println("7 - Rodar a folha de pagamento do dia");
            System.out.println("8 - Uno/Redo (Desfazer última operação)");
            System.out.println("9 - Agenda de pagamento");
            System.out.println("10 - Criar novas agendas de pagamento");
            System.out.println("12 - Mostrar todos os funcionário da empresa");

            System.out.println("11 - para sair do sistema");
            System.out.println(" ");

            Scanner input = new Scanner(System.in);
            enter = input.nextInt();

            switch(enter)
            {
                case 1:
                    addEmployee(employeesText, coutEmployee); // aadicionar empregado
                    numberEmployee[coutEmployee] = 1;
                    coutEmployee++;
                    break;
                case 2:
                    removeEmployee(employeesText, employeesValue, dateSales, payment, syndicate, numberEmployee); // remover empregado
                    break;
                case 3:
                    //ajeitar esse método, para pegar um por um
                    timeCard(employeesText, employeesValue, coutEmployee, salary, numberEmployee); // lançar cartão de ponto
                    break;
                case 4:
                    //ajeitar esse método, para pegar um por um
                    resultSales(employeesText, employeesValue, coutEmployee, salary, dateSales, numberEmployee); // resultado de venda
                    break;
                case 5:
                    serviceCharge(coutEmployee, syndicate, numberEmployee);// lançar uma taxa de serviço
                    break;
                case 6:
                    alterEmployee(employeesText, employeesValue, coutEmployee, numberEmployee); // alterar empregado
                    break;
                case 7:
                    DayPayment(employeesText, employeesValue, coutEmployee, payment, syndicate, numberEmployee); // rodar a folha de pagamento para hoje
                    break;
                case 8:
                    System.out.println("Método ainda não implementado");
                    break;
                case 9:
                    paymentShedule(employeesText, employeesValue, coutEmployee, payment, numberEmployee); // agenda de pagamento
                    break;
                case 10:
                    newPaymentShedule(employeesText, employeesValue, coutEmployee, payment, numberEmployee); //Criação de Novas Agendas de Pagamento
                    break;
                case 11:
                    loop = false;
                    break;
                case 12:
                    printEmployees(employeesText, coutEmployee, numberEmployee);
                    break;
            }


        }
    }
}

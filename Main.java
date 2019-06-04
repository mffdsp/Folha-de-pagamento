package com.company;
import java.util.Scanner;

public class Main
{

    public static void addEmployee(String[][] myEmployeeText, int number, int [][] payment)
    {
        int t = 0, v = 0, type;
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do empregado: ");
        myEmployeeText[t][number] = input.nextLine();
        t++;

        System.out.print("Endereço do empregado: ");
        myEmployeeText[t][number] = input.nextLine();
        t++;

        System.out.println("Escolha um tipo de empregado, dos tipos abaixo, escolhendo o indice");
        System.out.println("1 - horista");
        System.out.println("2 - assalariado");
        System.out.println("3 - comissionado");
        type = input.nextInt();
        if(type == 1)
        {
            myEmployeeText[t][number] = "horista";
            myEmployeeText[3][number] = "semanal";
            payment[0][number] = 5;
        }
        if(type == 2)
        {
            myEmployeeText[t][number] = "assalariado";
            myEmployeeText[3][number] = "mensal";
            payment[0][number] = 31;
        }
        if(type == 3) {
            myEmployeeText[t][number] = "comissionado";
            myEmployeeText[3][number] = "quinzenal";
            payment[0][number] = 15;
        }
        payment[1][number] = 3;
        t++;

        System.out.println("Empregado " + myEmployeeText[0][number] + " adicionado.");
    }

    public static void removeEmployee(String[][] myEmployeeText, double[][] myEmployeeValue, int[][] dateSales, int[][] payment, int [][]syndicate, int[] numEmployee)
    {
        int numberEm, t, v;
        String clean = " ", remov;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número do empregado que deseja remover: ");
        numberEm = input.nextInt();
        remov = myEmployeeText[0][numberEm];
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
        System.out.println("Empregado " + remov + " removido.");
    }

    public static void alterEmployee(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int[] numEmployee)
    {
        int numberEm, option, t = 0, v = 0, type;
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número do empregado que deseja alterar: ");
        numberEm = input.nextInt();
        input.nextLine();
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
                input.nextLine();

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
                        System.out.println("Escolha um novo tipo de empregado, dos tipos abaixo, escolhendo o indice");
                        System.out.println("1 - horista");
                        System.out.println("2 - assalariado");
                        System.out.println("3 - comissionado");
                        type = input.nextInt();
                        if(type == 1)
                            myEmployeeText[2][numberEm] = "horista";
                        if(type == 2)
                            myEmployeeText[2][numberEm] = "assalariado";
                        if(type == 3)
                            myEmployeeText[2][numberEm] = "comissionado";
                        break;
                    case 4:
                        loop = false;
                        break;
                }
            }
        }
        System.out.println("Alterações feitas.");
    }

    public static void timeCard(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, double salary, int [] numEmployee)
    {
        int hour, extra, i;
        Scanner input = new Scanner(System.in);

        System.out.println("Entre com o número do funcionário");
        i = input.nextInt();
        if(numEmployee[i] == 1)
        {
            if("horista".equals(myEmployeeText[2][i]))
            {
                System.out.print("Entre com a quantidade de horas trabalhadas: ");
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
            else
            {
                System.out.println("Funcionário não é do tipo horista");
            }
        }

    }

    public static void resultSales(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, double salary, int [][] sales, int[] numEmployee)
    {
        int i;
        double comission = 0.1;
        Scanner input = new Scanner(System.in);
        System.out.println("Entre com o número do funcionário");
        i = input.nextInt();

        if(numEmployee[i] == 1)
        {
            if ("comissionado".equals(myEmployeeText[2][i]))
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
            else
            {
                System.out.println("Funcionário não é do tipo comissionado");
            }
        }

    }

    public static void paymentShedule(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int [][] payment, int[] numEmployee)
    {
        int i, x;
        Scanner input = new Scanner(System.in);

        System.out.print("Entre com o número do empregado: ");
        i = input.nextInt();
        input.nextLine();
        if(numEmployee[i] == 1)
        {
            if("mensal".equals(myEmployeeText[2][i]))
            {
                System.out.println("Empregado é pago todo dia " + payment[0][i] + " de todo mês");
            }
            if("semanal".equals(myEmployeeText[2][i]))
            {
                if(payment[0][i] == 1)
                    System.out.println("Empregado é pago toda segunda-feira");
                if(payment[0][i] == 2)
                    System.out.println("Empregado é pago toda terça-feira");
                if(payment[0][i] == 3)
                    System.out.println("Empregado é pago toda quarta-feira");
                if(payment[0][i] == 4)
                    System.out.println("Empregado é pago toda quinta-feira");
                if(payment[0][i] == 5)
                    System.out.println("Empregado é pago toda sexta-feira");
            }
            if("quinzenal".equals(myEmployeeText[2][i]))
            {
                x = (payment[0][i]+15)%31;
                System.out.println("Empregado é pago dia " + payment[0][i] + " e " + x);
            }
            System.out.println("Escolha o método de pagamento para o empregado " + myEmployeeText[0][i] + " :");
            System.out.println("1 - Cheque pelos correios (nenos recomendado)");
            System.out.println("2 - Cheque em mãos");
            System.out.println("3 - Deposito em conta bancária");
            payment[1][i] = input.nextInt();
        }
        System.out.println("Agenda feita");
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
            System.out.println("1 - mensal escolhendo o dia do mês para ser pago (PARA EMPREGADOS ASSALARIADOS)");
            System.out.println("2 - semanal escolhendo o dia da semana para ser pego (PARA EMPREGADOS HORISTAS)");
            System.out.println("3 - semanal a cada duas semana para receber (PARA EMPREGADOS COMISSIONADOS)");
            enter = input.nextInt();
            input.nextLine();

            switch (enter)
            {
                case 1:
                    if("assalariado".equals(myEmployeeText[2][i]))
                    {
                        System.out.print("escolha um dia do mês(entre 1 e 31): ");
                        payment[0][i] = input.nextInt();
                    }
                    else
                        System.out.println("Empregado não é do tipo ASSALARIADO");
                    break;
                case 2:
                    if("horista".equals(myEmployeeText[2][i]))
                    {
                        System.out.print("escolha um dia da semana (EM EXTENSO, ex.: 'segunda'): ");
                        week = input.nextLine();
                        if ("segunda".equals(week))
                            payment[0][i] = 1;
                        if ("terça".equals(week))
                            payment[0][i] = 2;
                        if ("quarta".equals(week))
                            payment[0][i] = 3;
                        if ("quinta".equals(week))
                            payment[0][i] = 4;
                        if ("sexta".equals(week))
                            payment[0][i] = 5;
                    }
                    else
                        System.out.println("Empregado não é do tipo HORISTA");
                    break;
                case 3:
                    if("comissionado".equals(myEmployeeText[2][i]))
                    {
                        System.out.print("escolha um dia do mês que o empregado irá receber(entre 1 e 31), sabendo que ele será pago novamente após 15 dias");
                        payment[0][i] = input.nextInt();
                    }
                    else
                        System.out.println("Empregado não é do tipo COMISSIONADO");
                    break;
            }
        }
        else
        {
            System.out.println("Empregado não existe.");
        }
        System.out.println("Nova agenda feita\n");
    }

    public static void leafPayment(String[][] myEmployeeText, double[][] myEmployeeValue, int i, int [][] payment, double offSalary)
    {
        double salary;
        if("comissionado".equals(myEmployeeText[2][i]))
        {
            System.out.println("Pagamento do empregado......... " + myEmployeeText[0][i]);
            salary = (myEmployeeValue[1][i]+myEmployeeValue[2][i]+myEmployeeValue[3][i]) - offSalary;
            System.out.println("Valor.......................... " + salary);

        }
        if("horista".equals(myEmployeeText[2][i]))
        {
            System.out.println("Pagamento do empregado......... " + myEmployeeText[0][i]);
            salary = myEmployeeValue[0][i] - offSalary;
            System.out.println("Valor.......................... " + salary);
        }
        if("assalariado".equals(myEmployeeText[2][i]))
        {
            System.out.println("Pagamento do empregado......... " + myEmployeeText[0][i]);
            salary = myEmployeeValue[1][i] - offSalary;
            System.out.println("Valor.......................... " + salary);
        }
        if(payment[1][i] == 2)
            System.out.print("Cheque entregue em mãos\n\n\n");

        if(payment[1][i] == 1)
            System.out.print("Cheque enviado pelos correios\n\n\n");

        if(payment[1][i] == 3)
            System.out.print("Depósito feito\n\n\n");

        myEmployeeValue[0][i] = 0;
        myEmployeeValue[1][i] = 0;
        myEmployeeValue[2][i] = 0;
        myEmployeeValue[3][i] = 0;
    }

    public static void DayPayment(String[][] myEmployeeText, double[][] myEmployeeValue, int cout, int[][] payment, int [][]syndicate, int[] numEmployee, double dindin)
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
                            myEmployeeValue[1][i] = dindin;
                            leafPayment(myEmployeeText, myEmployeeValue, i, payment,offSalary);
                        }
                    }
                    if("semanal".equals(myEmployeeText[3][i]))
                    {
                        if(day == payment[0][i] || day == ((payment[0][i]+7)%31) || day == ((payment[0][i]+14)%31) || day == ((payment[0][i]+21))%31)
                        {
                            leafPayment(myEmployeeText, myEmployeeValue, i, payment, offSalary);
                        }
                    }
                    if("quinzenal".equals(myEmployeeText[3][i]))
                    {
                        if(day == payment[0][i] || day == (payment[0][i]+15)%31)
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
                System.out.println("1 - assistência médica");
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
                        System.out.println("Empregado cadastrado na assistência médica");
                        break;
                    case 2:
                        syndicate[1][employee] = 1;
                        System.out.println("Empregado cadastrado na assistencia farmacêutica");
                        break;
                    case 3:
                        syndicate[2][employee] = 1;
                        System.out.println("Empregado cadastrado no clube esportivo");
                        break;
                    case 4:
                        syndicate[3][employee] = 1;
                        System.out.println("Empregado cadastrado na assistencia à martenidade");
                        break;
                    case 5:
                        syndicate[4][employee] = 1;
                        System.out.println("Empregado cadastrado no auxílio congresso/conferência");
                        break;
                    case 6:
                        syndicate[5][employee] = 1;
                        System.out.println("Empregado cadastrado na assistência de bolsas estudos");
                        break;
                    case 7:
                        loop = false;
                        break;
                }
            }
        }
    System.out.println("Alterações feitas\n");
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

    public static void printEmployees(String[][] myEmployeeText, int max, int[] numEmployee, int [][] payment, int [][] syndicate)
    {
        int i, end;
        for(i = 0 ; i < max ; i++)
        {
            if(numEmployee[i] == 1)
            {
                System.out.println("Nome: " + myEmployeeText[0][i]);
                System.out.println("Número: " + i);
                System.out.println("Endereço: " + myEmployeeText[1][i]);
                System.out.println("Tipo: " + myEmployeeText[2][i]);

                System.out.println("Dia do pagamento: " + payment[0][i]);
                System.out.println("Tipo do pagamento: " + payment[1][i]);

                if(syndicate[0][i] == 1)
                    System.out.println("Empregado cadastrado na assistência médica");
                if(syndicate[1][i] == 1)
                    System.out.println("Empregado cadastrado na assistencia farmacêutica");
                if(syndicate[2][i] == 1)
                    System.out.println("Empregado cadastrado no clube esportivo");
                if(syndicate[3][i] == 1)
                    System.out.println("Empregado cadastrado na assistencia à martenidade");
                if(syndicate[4][i] == 1)
                    System.out.println("Empregado cadastrado no auxílio congresso/conferência");
                if(syndicate[5][i] == 1)
                    System.out.println("Empregado cadastrado na assistência de bolsas estudos");
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println("Digite qualquer número para sair\n");
        Scanner input = new Scanner(System.in);
        end = input.nextInt();
    }

    public static void welcome()
    {
        System.out.println("- Sistema de folha de Pagamento -");
        System.out.println("Seguiremos o seguinte modelo como calendário: ");
        System.out.println("S  T  Q  Q  S  S  D");
        System.out.print("1  2  3  4  5  6  7\n" +
                         "8  9  10 11 12 13 14\n"+
                         "15 16 17 18 19 20 21\n"+
                         "22 23 24 25 26 27 28\n"+
                         "29 30 31\n\n");
        System.out.println("Todos os meses seguirão esse mesmo padrão");
        System.out.println("Todos os funcionários terão seus números por ordem que foram adicionados");
        System.out.println("Exemplo, o primeiro funcionário terá o seu numero sendo 0, o segundo sendo 1, ...\n\n");
        int end;
        System.out.println("Digite qualquer coisa para sair");
        Scanner input = new Scanner(System.in);
        //end = input.nextInt();
        input.nextLine();

    }

    public static void spaces()
    {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
        welcome();
        spaces();
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
            System.out.println("11 - Mostrar todos os funcionário da empresa");
            System.out.println("12 - para sair do sistema");

            Scanner input = new Scanner(System.in);
            enter = input.nextInt();

            switch(enter)
            {
                case 1:
                    addEmployee(employeesText, coutEmployee, payment); // aadicionar empregado
                    numberEmployee[coutEmployee] = 1;
                    coutEmployee++;
                    break;
                case 2:
                    removeEmployee(employeesText, employeesValue, dateSales, payment, syndicate, numberEmployee); // remover empregado
                    break;
                case 3:
                    timeCard(employeesText, employeesValue, coutEmployee, salary, numberEmployee); // lançar cartão de ponto
                    break;
                case 4:
                    resultSales(employeesText, employeesValue, coutEmployee, salary, dateSales, numberEmployee); // resultado de venda
                    break;
                case 5:
                    serviceCharge(coutEmployee, syndicate, numberEmployee);// lançar uma taxa de serviço
                    break;
                case 6:
                    alterEmployee(employeesText, employeesValue, coutEmployee, numberEmployee); // alterar empregado
                    break;
                case 7:
                    DayPayment(employeesText, employeesValue, coutEmployee, payment, syndicate, numberEmployee, salary); // rodar a folha de pagamento para hoje
                    break;
                case 8:
                    System.out.println("Desculpas, esse método ainda não foi implementado");
                    break;
                case 9:
                    paymentShedule(employeesText, employeesValue, coutEmployee, payment, numberEmployee); // agenda de pagamento
                    break;
                case 10:
                    newPaymentShedule(employeesText, employeesValue, coutEmployee, payment, numberEmployee); //Criação de Novas Agendas de Pagamento
                    break;
                case 11:
                    printEmployees(employeesText, coutEmployee, numberEmployee, payment, syndicate);
                    break;
                case 12:
                    loop = false;
                    break;
            }
        }
    }
}

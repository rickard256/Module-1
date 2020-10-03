import java.util.Scanner;

class SmartCalc
{
    double[] memory = new double[10];
    int memorySlot = 0;
    static public void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String username = input.nextLine();
        System.out.println("Nice to meet you, " + username);
        System.out.println("I am a smart calculator. You can give me numbers and tell me what to do with them");
        System.out.println("I can store up to 10 different values");
        System.out.println("");

        //Creating important variables
        String userInput;
        SmartCalc sc = new SmartCalc();
        double firstNum;
        double secondNum;
        double result;
        int expInt;
        boolean exit = false;
        String spaceRemover;
        do
        {
            System.out.println("Please type a math symbol, type 'array' to see my memory,");
            System.out.println("type 'help' for program assistance, type 'exit' to leave the program.");
            System.out.print("> ");
            userInput = input.nextLine();
            switch (userInput)
            {
            case "+":
            System.out.println("Type two numbers, hit enter after each number");
            firstNum = input.nextDouble();
            secondNum = input.nextDouble();
            result = sc.addNum(firstNum, secondNum);
            sc.addToMemory(result);
            break;

            case "-":
            System.out.println("Type two numbers, hit enter after each number");
            firstNum = input.nextDouble();
            secondNum = input.nextDouble();
            result = sc.subNum(firstNum, secondNum);
            sc.addToMemory(result);
            break;

            case "*":
            System.out.println("Type two numbers, hit enter after each number");
            firstNum = input.nextDouble();
            secondNum = input.nextDouble();
            result = sc.multiNum(firstNum, secondNum);
            sc.addToMemory(result);
            break;

            case "/":
            System.out.println("Type two numbers, hit enter after each number");
            firstNum = input.nextDouble();
            secondNum = input.nextDouble();
            result = sc.divNum(firstNum, secondNum);
            sc.addToMemory(result);
            break;

            case "%":
            System.out.println("Type two numbers, hit enter after each number");
            firstNum = input.nextDouble();
            secondNum = input.nextDouble();
            result = sc.modNum(firstNum, secondNum);
            sc.addToMemory(result);
            break;

            case "^":
            System.out.println("Type one double, and then one integer. Hit enter after each number");
            firstNum = input.nextDouble();
            expInt = input.nextInt();
            result = sc.expNum(firstNum, expInt);
            sc.addToMemory(result);
            break;

            case "array":
            sc.displayMemory();
            System.out.println("Press 'enter' to exit the memory");
            break;

            case "help":
            System.out.println("The math symbols you can use are '+' '-' '*' '/' '%' '^'");
            break;

            case "exit":
            System.out.println("Thanks for using the program, " + username + ". See you later!");
            exit = true;
            break;

            default:
            System.out.println("Invalid command, press 'enter' to continue.");
            break;
            }
            //This space remover is here to keep the program from incorrectly
            //reading the newLines cause by the enter key when typing out numbers
            spaceRemover = input.nextLine();
            System.out.println(spaceRemover);
        }
        while(exit == false);   
    }
    public void displayMemory()
    {
        System.out.println("The memory contains");
        for (int j = 0; j < memory.length; j++)
        System.out.print("Slot " + j + "[" + String.format("%.2f", memory[j]) + "] ");
        System.out.println("");
    }

    public void addToMemory(double result)
    {
        if (memorySlot == 10)
        {
            memorySlot = 0;
        }
        memory[memorySlot] = result;
        memorySlot++;
    }

    //Adding Function
    public double addNum(double numOne, double numTwo)
    {
        return (numOne + numTwo);
    }

    //Subtraction Function
    public double subNum(double numOne, double numTwo)
    {
        return (numOne - numTwo);
    }

    //Multiplication Function
    public double multiNum(double numOne, double numTwo)
    {
        return (numOne * numTwo);
    }

    //Division Function
    public double divNum(double numOne, double numTwo)
    {
        return (numOne / numTwo);
    }

    //Modulo Function
    public double modNum(double numOne, double numTwo)
    {
        return (numOne % numTwo);
    }

    //Exponent Function
    public double expNum(double numOne, int numTwo)
    {
        for (int i = 0; i < numTwo; i++)
        {
            numOne *= numOne;
        }
        return numOne;
    }
}
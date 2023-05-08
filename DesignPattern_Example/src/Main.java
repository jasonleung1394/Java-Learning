// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        SingletonPattern singletonPattern = new SingletonPattern();
        System.out.println(singletonPattern.getPatternInfo());
        System.out.println(singletonPattern.singletonDemoOutput());


        FactoryPattern factoryPattern = new FactoryPattern();
        System.out.println(factoryPattern.getPatternInfo());
        ToyFactory toyFactory = new ToyFactory();
        Toy toyChild = toyFactory.getToy("Child");
        toyChild.whatToy();

        AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();
        System.out.println(abstractFactoryPattern.getPatternInfo());
        AbstractFactory factoryType =  AbstractFactoryPattern.getFactory("weird");
        ToyAF toyType = factoryType.getToyAF("Senior");
         toyType = factoryType.getToyAF("Elder");

        toyType.whatToy();
    }
}
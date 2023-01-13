public class HomeWork5 {

    public static void main(String[] args) {

        boolean booleanVar = true;  // true/false
        byte byteVar = 100;         // -128 ... 127
        short shortVar = 30000;     // -321768 ... 321767
        int intVar = 100500000;     // -2147483648 ... 2147483647
        long longVar = 1234567L;    // -9223372036854775808 ... 9223372036854775807
        // var varVar = 10;
        float floatVar = 1.23F;     // 3.4e-038 ... 3.4e+038
        double doubleVar = 1.23;    // 1.7e-308 ... 1.7e+308
        char charVar = 'r';

        String stringVar = "string woo";

        byte byteVarTwo = 120;
        // byte byteVarThree = byteVar + byteVarTwo; //error: incompatible types: possible lossy conversion from int to byte
        System.out.println(byteVar + shortVar);
        System.out.println(byteVar + floatVar);
        System.out.println(byteVar + doubleVar);
        System.out.println(byteVar + charVar);
        System.out.println(floatVar - doubleVar);
        System.out.println(intVar + doubleVar);
        System.out.println(intVar / doubleVar);
        System.out.println(byteVar += 130);

    }


}

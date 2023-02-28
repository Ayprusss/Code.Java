import java.util.Arrays; 

public class ArrayTypes {
    public static void main(String[] args) {
        int[] numbers = new int[5]; //due to a list being a reference type, we need to use the new opeartor. For the array, we would also have to input what kind of data it is (int, double, etc), and then after we input how many new numbers we want in the array. 
        numbers[0] = 1;
        numbers[1] = 2;// older syntax to intialize an array though.
        System.out.println(numbers); //we can't print a list like this. By doing so, it's only printing the list by its address for the memory space of the list not the actual values themselves.
        Arrays.toString(numbers);
        System.out.println(Arrays.toString(numbers));

        int[] nums = {2,3,5,1,4};
        //nums.length; // will print out the length of the list itself; how many values are in the list
        System.out.println(nums.length); //once an array is made, its length cannot be changed or altered later on. So unlike python, no appending or insertion can be cone; it's only allowed if the list is made to hold a certain amount of numbers/


        Arrays.sort(nums); //sort function for arrays. this is immutable. IF it's put in the code, the list will be sorted and won't make a copy of the list itself. 
        System.out.println((Arrays.toString(nums)));
    }
}

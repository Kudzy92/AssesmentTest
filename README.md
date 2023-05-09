## Option 2: JAVA Task
```java
public class recursion {
 
	 public static void main(String[] args) {
 
		// Saves the string that would be reversed
		 String myStr = "emosewA si avaJ";
 
 
		//create Method and pass and input parameter string 
		 String reversed = reverse_string(myStr);
		 System.out.println("The reversed string is: " + reversed + "\nFibonacci Series of 10 numbers:0 1 1 2 3 5 8 13 21 34 ");
	

	}
 
 
	//Method take string parameter and check string is empty or not
	 public static String reverse_string(String myStr)
	{
		 if (myStr.isEmpty()){
		 System.out.println("String in now Empty");
		 return myStr;
		}
		//Calling Function Recursively
		System.out.println("String to be passed in Recursive Function: "+myStr.substring(1));
		return reverseString(myStr.substring(1)) + myStr.charAt(0);}

	public static <T> void function(T maxNumber) {
		// Set it to the number of elements you want in the Fibonacci Series
		int maxNumber = 10; 
		int previousNumber = 0;
		int nextNumber = 1;
		 
	    System.out.print("Fibonacci Series of "+maxNumber+" numbers:");
 
	for (int i = 1; i <= maxNumber; ++i){
	    System.out.print(previousNumber+" ");
	    // On each iteration, we are assigning second number
	    // to the first number and assigning the sum of last two
	    // numbers to the second number
	    int sum = previousNumber + nextNumber;
	    previousNumber = nextNumber;
	    nextNumber = sum;
	    }
 
	}
 
}
```
### Corrections
1. ClassName should start with uppercase and more meaningful  ``` public class recursion  ``` to ``` public class ReverseStringAndFibonacci { ```
2. Functions names should be uppercase and meaningful no wild chars supported like underscores ``` reverse_string ``` to  ```reverseString ```
3. No need to return empty string. You should test whether the string is empty then you just return once.
 ```java
 if (!myStr.isEmpty()){
        System.out.println("String in now Empty");
    return myStr;  
    } 
```
 to
 ```java 
 String str="";
    if (!myStr.isEmpty()){
   str=reverseString(myStr.substring(1)) + myStr.charAt(0);   
    }
return str;
```
3. Don't declare variables with same names more than once per class or remove it completely and extends a generic data type <T> should extends a Number for type safety i.e < T extends Number > then the function should return a string
```java
public static <T> void function(T maxNumber) {
		// Set it to the number of elements you want in the Fibonacci Series
		int maxNumber = 10; 
```
change to

```java
public static <T extends Number > String fabonacciSequenceCreator(T maxNumber) {
   		int previousNumber = 0;
   	int nextNumber = 1;
   	String str="";
       System.out.print("Fibonacci Series of "+maxNumber+" numbers:");

   for (int i = 1; i <= (int) maxNumber; ++i) {
       int sum = previousNumber + nextNumber;
       previousNumber = nextNumber;
       nextNumber = sum;
       if((int) nextNumber<= (int) maxNumber && (int) nextNumber>0){
     str+=", "+nextNumber;
       }
    }
```
4. Every time you write code you should write test cases especially unit testing for each method
 ```java
 void isTheReversStringWorking(){
 var obj=new ClassnameToBeTested();
 assertEquals("Java is awesome",obj.reverseStrin("emosewA si avaJ"));
 }
 ```
 5. Always apply OOP principles such as Abstraction, encapsulation, polymorphism, and inheritance.
 6. Implementing generics data types was the best practice
 
 ## Final Solution
 ```java
 public class ReverseStringAndFibonacci {
public static void main(String[] args) {
   	 String myStr = "emosewA si avaJ";
   	 String reversed = reverseString(myStr);
   	 fabonacciSequenceCreator(100);
   	System.out.println("The reversed string is: " + reversed + "\nFibonacci Series "+fabonacciSequenceCreator(100));
   }
   public static String reverseString(String myStr) {
    String str="";
   if (!myStr.isEmpty()){
  str=reverseString(myStr.substring(1)) + myStr.charAt(0);   
   }
return str;
   }
public static <T extends Number > String fabonacciSequenceCreator(T maxNumber) {
   		int previousNumber = 0;
   	int nextNumber = 1;
   	String str="";
       System.out.print("Fibonacci Series of "+maxNumber+" numbers:");

   for (int i = 1; i <= (int) maxNumber; ++i) {
       int sum = previousNumber + nextNumber;
       previousNumber = nextNumber;
       nextNumber = sum;
       if((int) nextNumber<= (int) maxNumber && (int) nextNumber>0){
     str+=", "+nextNumber;
       }
    }
	
 }
 
 ```
	
## Comprehensive program 
	
Kindly visit the link below
	
[(https://github.com/Kudzy92/Java-Code/tree/Fabonacci-Sequence-And-String-Reverse)](https://github.com/Kudzy92/Java-Code/tree/Fabonacci-Sequence-And-String-Reverse)
  
 # Section A: Code Review
## Option 1: Python Task 
```python
class Solution:
       def groupAnagrams(self, strs):
      result = {}
      for i in strs:
         x = "".join(sorted())
         if x in result:
            result[x].append(i)
         else:
            result[x] = [i]
      return list(result.values())
ob1 = Solution()
print(ob1.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
```

#### NOTES

1.  Classname should be informative  `class AnagramSolution:`
2.  Your should indent your code to avoid IndentationError. Just like

```python
class Solution:
    def groupAnagrams(self, strs):
         result = {}
         for i in strs:
             x = "".join(sorted(i))
         if x in result:
             result[x].append(i)
         else:
             result[x] = [i]
         return list(result.values())
ob1 = Solution()
print(ob1.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))

```
 




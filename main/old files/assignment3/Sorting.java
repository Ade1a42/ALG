package assignment3;
public class Sorting {
    public char[] StrBubleSort(char[] word){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 0; i < word.length-1; i++){
                if(word[i] > word[i+1]){
                    swapped = true;
                    char temp = word[i];
                    word[i] = word[i+1];
                    word[i+1] = temp;
                }
            }
        }
        return word;
    }

    public void IntBubleSort(int[] array){
            boolean swapped = true;
            while(swapped){
                swapped = false;
                for(int i = 0; i < array.length-1; i++){
                    if(array[i] > array[i+1]){
                        swapped = true;
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                    }
                }
            }
        }
}

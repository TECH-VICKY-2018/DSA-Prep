import java.util.ArrayList;
import java.util.List;

public class SearchInRotatedArray {

    public static int search_element(List<Integer> arr, int target) {
        // Write your code here
        int l =0;
        int h = arr.size()-1;
        while(l<=h){
            int m = l+ h-l/2;

            if(target == arr.get(m)){return m;}
            else if(arr.get(m)>=arr.get(l)){ // left sorted
                if(target >=arr.get(l) && target < arr.get(m)){
                    h = m-1;
                }
                else{
                    l= m+1;
                }
            }
            else {
                if(target > arr.get(m) && target<=arr.get(h)){
                    l=m+1;

                }
                else{
                    h = m-1;

                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(0);
        myList.add(1);
        myList.add(2);

        System.out.println(search_element(myList,4));
    }
}

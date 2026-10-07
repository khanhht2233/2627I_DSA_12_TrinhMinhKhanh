import java.util.Scanner;

public class BasicsSort {
    public static void selectionSort(int[] a){
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) minIdx = j ;
            }
            //swap
            int tmp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = tmp;
        }
    }

    public static void insertionSort(int[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int j = i-1;
            int key = a[i];

            while (j >= 0 && key < a[j]){
                a[j+1] = a[j];
                j -= 1;
            }
            a[j+1] = key;

            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);

//        for (int i = n; i > 0 ; i--) {
//            int cnt = 0;
//            for (int j = n-1; j >= 0; j--) {
//                if (arr[j] >= i) cnt += 1;
//            }
//            if (cnt == i) {
//                System.out.println(cnt);
//                break;
//            }
//            else cnt = 0;
//        }
    }
}

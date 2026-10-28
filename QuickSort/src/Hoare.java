import java.util.Scanner;

public class Hoare {

    public static int partition(int a[], int l, int r){
        int pivot = a[l];
        int i = l - 1, j = r + 1;
        do{
            ++i;
        }while(a[i] < pivot);
        do{
            --j;
        }while(a[j] > pivot);
        if (i < j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return j;
    }

    public static void quickSort(int a[], int l, int r){
        if (l >= r) return;
        int p = partition(a, l, r);
        quickSort(a, l, p);
        quickSort(a, p+1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[1000];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

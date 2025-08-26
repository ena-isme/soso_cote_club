 //http://boj.kr/c12e8bc6496245d196cd912073b3ffc0

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 import java.io.IOException;

 import java.util.StringTokenizer;
 import java.util.Queue;
 import java.util.LinkedList;

 public class Main {

     static int N, K;
     static int[] arr = new int[100001];

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

         int result = method(N);

         bw.write(result + "");
         bw.flush();
         bw.close();
     }

     public static int method(int N) {
         Queue<Integer> queue = new LinkedList<>();
         queue.add(N);
         while (!queue.isEmpty()) {
             int data = queue.poll();

             if (data == K) {
                 return arr[data];
             }

             if (data - 1 >= 0 && arr[data - 1] == 0) {
                 arr[data - 1] = arr[data] + 1;
                 queue.add(data - 1);
             }

             if (data + 1 < 100001 && arr[data + 1] == 0) {
                 arr[data + 1] = arr[data] + 1;
                 queue.add(data + 1);
             }

             if (data * 2 < 100001 && arr[data * 2] == 0) {
                 arr[data * 2] = arr[data] + 1;
                 queue.add(data * 2);
             }
         }

         return -1;
     }
 }
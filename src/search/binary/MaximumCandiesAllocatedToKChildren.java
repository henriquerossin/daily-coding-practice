package search.binary;

    /*
    LeetCode 2226. Maximum Candies Allocated to K Children
    https://leetcode.com/problems/maximum-candies-allocated-to-k-children/

    You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.

    You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.

    Return the maximum number of candies each child can get.



    Example 1:

    Input: candies = [5,8,6], k = 3
    Output: 5
    Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.

    Example 2:

    Input: candies = [2,5], k = 11
    Output: 0
    Explanation: There are 11 children but only 7 candies in total, so it is impossible to ensure each child receives at least one candy. Thus, each child gets no candy and the answer is 0.


    Constraints:

    1 <= candies.length <= 105
    1 <= candies[i] <= 107
    1 <= k <= 1012
    */

import java.util.Scanner;

public class MaximumCandiesAllocatedToKChildren {

    // Método que calcula o máximo número de doces que cada criança pode receber
    public int maximumCandies(int[] candies, long k) {

        // 'left' é o menor tamanho de pedaço que vamos testar (1 doce)
        int left = 1;

        // 'right' é o maior monte de doces no array (limite máximo para pedaço)
        int right = 0;

        // Percorremos todos os montes para encontrar o maior valor
        for (int c : candies) {
            if (c > right) {
                right = c;
            }
        }

        // Variável para armazenar a melhor resposta encontrada
        int result = 0;

        // Enquanto o intervalo de busca for válido (left <= right)
        while (left <= right) {

            // Calculamos o meio do intervalo atual para testar como possível tamanho de pedaço
            int mid = left + (right - left) / 2;

            // Contador de quantos pedaços desse tamanho conseguimos cortar ao todo
            long count = 0;

            // Para cada monte de doces
            for (int c : candies) {
                // Adicionamos quantos pedaços de tamanho 'mid' esse monte pode fornecer
                count += c / mid;

                // Se já conseguimos atender todas as crianças, podemos parar de contar
                if (count >= k) break;
            }

            // Se conseguimos fazer pedaços suficientes para todas as crianças
            if (count >= k) {
                // Guardamos esse tamanho como possível resposta
                result = mid;

                // Tentamos aumentar o tamanho do pedaço para ver se conseguimos melhorar a resposta
                left = mid + 1;
            } else {
                // Se não conseguimos, tentamos pedaços menores
                right = mid - 1;
            }
        }

        // Retornamos o maior tamanho possível de pedaço que atende todas as crianças
        return result;
    }

    // Método main para ler entrada do usuário e testar o método acima
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Perguntamos quantos montes de doces existem
        System.out.print("Quantos montes de doces? ");
        int n = sc.nextInt();

        int[] candies = new int[n];

        // Para cada monte, perguntamos o tamanho dele
        System.out.println("Digite o tamanho de cada monte:");
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        // Perguntamos quantas crianças vão receber os doces
        System.out.print("Quantas crianças? ");
        long k = sc.nextLong();

        // Criamos o objeto que tem o método para resolver o problema
        MaximumCandiesAllocatedToKChildren solver = new MaximumCandiesAllocatedToKChildren();

        // Chamamos o método e guardamos o resultado
        int result = solver.maximumCandies(candies, k);

        // Imprimimos o resultado final para o usuário
        System.out.println("Maior número de doces que cada criança pode receber: " + result);

        sc.close();
    }
}
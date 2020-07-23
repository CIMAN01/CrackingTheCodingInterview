/*

Cracking the Coding Interview

17.2 (Hard)

Shuffle: Write a method to shuffle a deck of cards. It must be a perfect shuffle-in other words,
         each of 52! permutations of the deck has to be equally likely. Assume that you are given
         a random number generator which is perfect.

*/


import java.util.Arrays;
import java.util.Random;


// main class
public class ShuffleDeckOfCards {

    // a method that shuffles an array of cards recursively
    public static int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) {
            return cards;
        }

        /* shuffle elements 0 through index - 1 */
        shuffleArrayRecursively(cards, i - 1);
        Random rand = new Random();
        // Generate random between 0 and i (inclusive)
        int k = rand.nextInt(i + 1);

        /* Swap element k and index */
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        /* Return shuffled array */
        return cards;
    }

    // a method that shuffles an array of cards iteratively (this is the standard solution)
    public static void shuffleArrayIteratively(int[] cards) {
        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            // Generate random between 0 and i (inclusive)
            int k = rand.nextInt(i + 1);
            // Swap element and index
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }

    // main method
    public static void main(String[] args) {
        System.out.println();
        int[] cardS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArrayRecursively(cardS, 9);
//        System.out.println(Arrays.toString(cardS));
        System.out.println();
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("cards before shuffle: " + Arrays.toString(cards));
        System.out.println();
        shuffleArrayIteratively(cards);
        System.out.println("cards shuffled: " + Arrays.toString(cards));
    }

}

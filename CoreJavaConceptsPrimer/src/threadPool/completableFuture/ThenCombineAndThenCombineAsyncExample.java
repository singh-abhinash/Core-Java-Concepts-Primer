package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenCombineAndThenCombineAsyncExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync for future1: Initial task on thread: " + Thread.currentThread().getName());
            return 20;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync for future2: Initial task on thread: " + Thread.currentThread().getName());
            return 30;
        });

        future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("thenCombine: Combining results on thread: " + Thread.currentThread().getName() 
                               + ", Result: " + (result1 + result2));
            return result1 + result2;
        });

        future1.thenCombineAsync(future2, (result1, result2) -> {
            System.out.println("thenCombineAsync: Combining results asynchronously on thread: " 
                               + Thread.currentThread().getName() + ", Result: " + (result1 + result2));
            return result1 + result2;
        });

        future1.join();
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> thenCombine() allows you to combine the results of two CompletableFutures once both complete. It takes another 
 * CompletableFuture and a function to combine both results.
 * -> thenCombineAsync() does the combination asynchronously in a separate thread.
 */
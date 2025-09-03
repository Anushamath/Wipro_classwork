package com.wipro.threads;

/*Wap to create two users user-A and user-B to perform some task(file upload )( they both are threads thread-A and thread-B )
 *  main thread will wait for both users before showing the task is completed of user-A and user-B
 */
public class FileUploadTask {

    // User thread class simulating file upload
    static class UserThread extends Thread {
        private String userName;

        public UserThread(String username) {
            this.userName = username;
        }

        @Override
        public void run() {
            System.out.println(userName + " started uploading the file...");
            try {
                Thread.sleep(2000); // simulate time taken to upload
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(userName + " finished uploading the file.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Creating threads for User-A and User-B
        Thread userA = new UserThread("User-A");
        Thread userB = new UserThread("User-B");

        // Starting both threads
        userA.start();
        userA.join();
        userB.start();
        userB.join();
//        try {
//            // Main thread waits for both threads to complete
//            userA.join();
//            userB.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // Once both uploads are done
        System.out.println("Both User-A and User-B have completed their tasks. Main thread proceeding.");
    }
}

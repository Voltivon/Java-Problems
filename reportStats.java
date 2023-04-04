public static void reportStatistics(String inputFileName) throws IOException {
    // Open the input file and instantiate a Scanner object to read the file
    Scanner myFileReader = new Scanner(new FileInputStream(inputFileName));

    // Initialize variables to keep track of sum, count, min, and max
    int sum = 0;
    int count = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    // Loop through each integer in the file and update the variables
    while (myFileReader.hasNextInt()) {
        int num = myFileReader.nextInt();
        sum += num;
        count++;
        if (num < min) {
            min = num;
        }

    // Calculate the average
    float avg = (float) sum / count;

    // Print the statistics to the console
    System.out.printf("Sum is     : %d\n", sum);
    System.out.printf("Average is : %.2f\n", avg);
    System.out.printf("Min is     : %d\n", min);
    System.out.printf("Max is     : %d\n", max);

    // Close the file reader
    myFileReader.close();
}
    

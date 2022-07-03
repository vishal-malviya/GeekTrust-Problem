package com.example.geektrust;

import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.Arguments;
import com.example.geektrust.model.UserSubscriptionManagement;
import com.example.geektrust.services.FileProcessorService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            // check for the file path in argument
            if (args.length != 1) {
                throw new CustomExceptionHandler("Test input file path is not passed as argument");
            }
            String filePath = args[0];
            // process input file
            FileProcessorService fileReaderService = new FileProcessorService(filePath);
            // Listing the arguments
            List<Arguments> arguments = fileReaderService.getCommandsFromFile();
            UserSubscriptionManagement userSubscriptionManagement =
                    new UserSubscriptionManagement();

            List<String> outputs =
                    arguments.stream()
                            .map(
                                    argument ->
                                            argument
                                                    .getOperator()
                                                    .getExecutionService()
                                                    .get()
                                                    .processOperation(argument.getOperands(), userSubscriptionManagement))
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
            //       print output
            outputs.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

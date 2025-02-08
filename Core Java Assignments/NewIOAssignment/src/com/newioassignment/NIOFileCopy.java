package com.newioassignment;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOFileCopy {
    public static void main(String[] args) {
 
        Path sourcePath = Path.of("source.txt");
        Path destinationPath = Path.of("destination.txt");

     
        try (
            FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
            FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)
        ) {
            
            ByteBuffer buffer = ByteBuffer.allocate(1024);

           
            while (sourceChannel.read(buffer) > 0) {
                buffer.flip(); 
                destinationChannel.write(buffer);
                buffer.clear(); 
            }

            System.out.println("File copied successfully using NIO!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package com.example.demo.singleton;

import java.io.*;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

public class demotry {


    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }
    static String firstLineOfFile1(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    static void copy1(String src, String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf,0,n);
        }

    }
}

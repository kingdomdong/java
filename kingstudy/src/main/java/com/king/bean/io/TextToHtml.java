package com.king.bean.io;

import java.io.*;

public class TextToHtml {

    public static void main(String[] args) {

        try {
            BufferedReader txtfile = new BufferedReader(new FileReader("c:\\test.txt"));
            OutputStream htmlfile = new FileOutputStream(new File("c:\\test.html"));
            PrintStream printhtml = new PrintStream(htmlfile);

            String[] txtbyLine = new String[500];
            String temp = "";
            String txtfiledata = "";

            String htmlheader = "<html><head>";
            htmlheader += "<title>Equivalent HTML</title>";
            htmlheader += "</head><body>";
            String htmlfooter = "</body></html>";
            int linenum = 0;

            while ((txtfiledata = txtfile.readLine()) != null) {
                txtbyLine[linenum] = txtfiledata;
                linenum++;
            }
            for (int i = 0; i < linenum; i++) {
                if (i == 0) {
                    temp = htmlheader + txtbyLine[0];
                    txtbyLine[0] = temp;
                }
                if (linenum == i + 1) {
                    temp = txtbyLine[i] + htmlfooter;
                    txtbyLine[i] = temp;
                }
                printhtml.println(txtbyLine[i]);
            }

            printhtml.close();
            htmlfile.close();
            txtfile.close();

        } catch (Exception e) {
        }

    }

}
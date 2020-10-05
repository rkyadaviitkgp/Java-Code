/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReportViewAcl {

    //get field value for given field name
    public static String getFiledValue(String fieldName, String fileName) throws FileNotFoundException, IOException {

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        StringBuffer inputBuffer = new StringBuffer();
        String line;
        boolean processing = false;
        while ((line = file.readLine()) != null) {
            if (line.contains("<" + fieldName + ">")) {
                line = line.substring(line.indexOf("<" + fieldName + ">") + 2 + fieldName.length());
                processing = true;
            }
            if (line.contains("</" + fieldName + ">")) {
                line = line.substring(0, line.indexOf("</" + fieldName + ">"));
                inputBuffer.append(line);
                break;
            }
            if (processing) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
        }
        file.close();
        String inputStr = inputBuffer.toString();
        return inputStr;
    }

    public static void printAllFieldOfFile(String[] arr, String fileName) throws IOException {
        System.out.println(" Filename : " + fileName);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " " + getFiledValue(arr[i], fileName));
        }
    }

    //update line in the file
    public static void replaceSelected(String fileName) {
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            boolean aclIsFalseOOB = true;
            while ((line = file.readLine()) != null) {
//                if (line.contains("<active>")) {
//                    if (line.contains("<active>true</active>")) {
//                        return; //no need of change 
//                    }
//                }
                if (line.contains("<sys_updated_on>") && aclIsFalseOOB) {
                    line = "    <sys_updated_on>2020-09-15 07:48:10</sys_updated_on>";
                } else if (line.contains("<sys_mod_count>") && aclIsFalseOOB) {
                    line = "    <sys_mod_count>2</sys_mod_count>";
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();

            //System.out.println(inputStr); // display the original file for debugging
            // logic to replace lines in the string (could use regex here to be generic)
            //inputStr = inputStr.replace(replaceTo, replaceWith);
            // display the new file for debugging
            //System.out.println("----------------------------------\n" + inputStr);
            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

    //check if the file is for report view acl 
    public static boolean findLine(String searchWord, String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.indexOf(searchWord) != -1) {
                return true;
            }
        }
        br.close();
        return false;
    }

    public static void fun1() throws IOException {

        //Creating a File object for directory
        ReportViewAcl reportViewAcl = new ReportViewAcl();
        String appCsmPluginPath = "/Users/rajeshkumar.yadav/newyork/app-cs/glide-app-csm/src/main/plugins";
        //appCsmPluginPath = "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins";
        String searchWord = "display_value=\"report_view\"";
        String replaceWord = "    <active>false</active>";
        String replaceWith = "    <active>true</active>";

        File directoryPath = new File(appCsmPluginPath);
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();

        //get all directory in app-csm plugin folders 
        int countOfDirectory = 0;
        int noOfFilesUpdated = 0;
        for (File file : filesList) {

            if (file.isDirectory()) {
                countOfDirectory++;
                String updateFolderPath = appCsmPluginPath + "/" + file.getName() + "/update";
                //for testing 
                //updateFolderPath = appCsmPluginPath + "/" + "com.snc.cs_base" + "/update";
                //System.out.println(updateFolderPath);

                //get all files in update folder 
                File updateDirectoryPath = new File(updateFolderPath);
                //List of all files and directories
                File updateFilesList[] = updateDirectoryPath.listFiles();
                if (updateFilesList != null) {
                    //System.out.println(updateFilesList.length);
                    for (File updateFile : updateFilesList) {
                        //System.out.println("file : " + updateFile.toString());

                        //check if the file is for report view acl
                        if (reportViewAcl.findLine(searchWord, updateFile.toString())) {
                            //reportViewAcl.replaceSelected(replaceWith, replaceWord, updateFile.toString());
                            noOfFilesUpdated++;
                        }
                    }
                } else {
                    System.out.println("0");
                }
                //for testing 
                //return;
            }
        }
        System.out.println("No of directory found is " + countOfDirectory);
        System.out.println("No of files updated is " + noOfFilesUpdated);

//        String arr[] = {"sys_updated_on", "sys_mod_count", "active", "script"};
//        String fileName = "/Users/rajeshkumar.yadav/newyork/app-cs/glide-app-csm/src/main/plugins/com.snc.cs_base/update/sys_script_include_64debc675352030097a2ddeeff7b1234.xml";
//        reportViewAcl.printAllFieldOfFile(arr, fileName);
    }

    public static void fun2(String fileName, String line, String subtitute) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        StringBuffer inputBuffer = new StringBuffer();

        while ((line = file.readLine()) != null) {
            if (line.contains(line)) {
                line = subtitute;
            }
            inputBuffer.append(line);
            inputBuffer.append('\n');

        }
        file.close();
        String inputStr = inputBuffer.toString();

    }

    public static void main(String args[]) throws IOException {

        String[] filesNames = {
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_1815a06c77b41010d7159b71a91061d7.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_2015e06c77b41010d7159b71a9106133.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_2415e06c77b41010d7159b71a9106105.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_5c15a06c77b41010d7159b71a91061f9.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_6815e06c77b41010d7159b71a9106127.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_9415282877b41010d7159b71a91061cb.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_9415a06c77b41010d7159b71a91061ee.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_a015e06c77b41010d7159b71a910611c.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_dc15a06c77b41010d7159b71a91061e2.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_e815e06c77b41010d7159b71a9106110.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_1815a06c77b41010d7159b71a91061f4.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_2415e06c77b41010d7159b71a9106122.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_5015a06c77b41010d7159b71a91061d2.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_5015a06c77b41010d7159b71a91061e9.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_6c15e06c77b41010d7159b71a9106116.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_9815a06c77b41010d7159b71a91061dd.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_a415e06c77b41010d7159b71a910610b.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_b015e06c77b41010d7159b71a9106139.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_e815e06c77b41010d7159b71a910612d.xml",
            "/Users/rajeshkumar.yadav/newyork/app-customerservice/app-customerservice/src/main/plugins/com.sn_customerservice/update/sys_security_acl_role_ec15a06c77b41010d7159b71a91061ff.xml"};
        for (int i = 0; i < filesNames.length; i++) {
            replaceSelected(filesNames[i]);
        }

    }

}

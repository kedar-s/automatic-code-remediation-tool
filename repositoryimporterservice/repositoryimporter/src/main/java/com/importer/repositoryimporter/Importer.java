/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.importer.repositoryimporter;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.jgit.api.Git;
import org.springframework.stereotype.Component;

/**
 *
 * @author kedar
 */
@Component
public class Importer
{

    public void clone(String url)
    {//testing phase
        /*
        try
        {
            Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(new File("../../clonedrepositories"))
                    .call();
        } catch (Exception e)
        {
            System.out.println("com.importer.repositoryimporter.Importer.clone()" + e.toString());
        }*/
        zip("./xd");
    }

    private void zip(String directory)
    {
        try {
            File fileToZip = new File(directory);
            FileOutputStream fos = new FileOutputStream(fileToZip.getName() + ".zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);


            zipFile(fileToZip, fileToZip.getName(), zipOut);
            zipOut.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut)throws IOException
    {
        if(fileToZip.isHidden())
            return;
        if(fileToZip.isDirectory())
        {
            if(fileName.endsWith("/"))
            {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            }
            else
            {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for(File child: children)
                zipFile(child, fileName + "/" + child.getName(), zipOut);
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0)
        {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}

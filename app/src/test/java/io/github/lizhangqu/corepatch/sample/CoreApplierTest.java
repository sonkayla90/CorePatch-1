package io.github.lizhangqu.corepatch.sample;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import io.github.lizhangqu.corepatch.applier.Applier;
import io.github.lizhangqu.corepatch.applier.ApplierException;
import io.github.lizhangqu.corepatch.applier.core.CoreApplier;
import io.github.lizhangqu.corepatch.applier.core.CoreApplierType;

/**
 * @author lizhangqu
 * @version V1.0
 * @since 2017-10-02 21:21
 */
public class CoreApplierTest {
    static File oldFile = new File("app/files/2.2.4.apk");

    static File archivePatchFileToFile = new File("app/files/archive-patch-out-to-file.diff");
    static File archivePatchFileToStream = new File("app/files/archive-patch-out-to-stream.diff");
    static File bsPatchFileToFile = new File("app/files/bs-patch-out-to-file.diff");
    static File bsPatchFileToStream = new File("app/files/bs-patch-out-to-stream.diff");
    static File totalFileToFile = new File("app/files/total-out-to-file.diff");
    static File totalFileToStream = new File("app/files/total-out-to-stream.diff");

    static File newArchivePatchFileToFile = new File("app/files/2.3.0-archive-patch-out-to-file.apk");
    static File newArchivePatchFileToStream = new File("app/files/2.3.0-archive-patch-out-to-stream.apk");

    static File newBsPatchFileToFile = new File("app/files/2.3.0-bs-patch-out-to-file.apk");
    static File newBsPatchFileToStream = new File("app/files/2.3.0-bs-patch-out-to-stream.apk");

    static File newTotalFileToFile = new File("app/files/2.3.0-total-out-to-file.apk");
    static File newTotalFileToStream = new File("app/files/2.3.0-total-out-to-stream.apk");
    @Test
    public void testApplyBsPatchOutToFile() throws ApplierException {
        long start = System.currentTimeMillis();
        Applier applier = CoreApplier.getInstance().getApplier(CoreApplierType.BS);
        try {
            applier.apply(oldFile, bsPatchFileToFile, newBsPatchFileToFile);
            Assert.assertTrue(newBsPatchFileToFile.exists());
            Assert.assertTrue(newBsPatchFileToFile.length() > 0);
            String md5 = applier.calculateMD5(newBsPatchFileToFile);
            System.out.println("md5:" + md5);
            Assert.assertNotNull(md5);
        } catch (ApplierException e) {
            e.printStackTrace();
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("testApplyBsPatchOutToFile time:" + (end - start));
        }
    }

    @Test
    public void testApplyBsPatchOutToStream() throws ApplierException, FileNotFoundException {
        long start = System.currentTimeMillis();
        Applier applier = CoreApplier.getInstance().getApplier(CoreApplierType.BS);
        try {
            applier.apply(oldFile, new FileInputStream(bsPatchFileToStream), new FileOutputStream(newBsPatchFileToStream));
            Assert.assertTrue(newBsPatchFileToStream.exists());
            Assert.assertTrue(newBsPatchFileToStream.length() > 0);
            String md5 = applier.calculateMD5(newBsPatchFileToStream);
            System.out.println("md5:" + md5);
            Assert.assertNotNull(md5);
        } catch (ApplierException e) {
            e.printStackTrace();
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("testApplyBsPatchOutToStream time:" + (end - start));
        }
    }

    @Test
    public void testApplyArchivePatchOutToFile() throws ApplierException {
        long start = System.currentTimeMillis();
        Applier applier = CoreApplier.getInstance().getApplier(CoreApplierType.ARCHIVE);
        try {
            applier.apply(oldFile, archivePatchFileToFile, newArchivePatchFileToFile);
            Assert.assertTrue(newArchivePatchFileToFile.exists());
            Assert.assertTrue(newArchivePatchFileToFile.length() > 0);
            String md5 = applier.calculateMD5(newArchivePatchFileToFile);
            System.out.println("md5:" + md5);
            Assert.assertNotNull(md5);
        } catch (ApplierException e) {
            e.printStackTrace();
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("testApplyArchivePatchOutToFile time:" + (end - start));
        }
    }

    @Test
    public void testApplyArchivePatchOutToStream() throws ApplierException, FileNotFoundException {
        long start = System.currentTimeMillis();
        Applier applier = CoreApplier.getInstance().getApplier(CoreApplierType.ARCHIVE);
        try {
            applier.apply(oldFile, new FileInputStream(archivePatchFileToStream), new FileOutputStream(newArchivePatchFileToStream));
            Assert.assertTrue(newArchivePatchFileToStream.exists());
            Assert.assertTrue(newArchivePatchFileToStream.length() > 0);
            String md5 = applier.calculateMD5(newArchivePatchFileToStream);
            System.out.println("md5:" + md5);
            Assert.assertNotNull(md5);
        } catch (ApplierException e) {
            e.printStackTrace();
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("testApplyArchivePatchOutToStream time:" + (end - start));
        }
    }

    @Test
    public void testApplyTotalOutToFile() throws ApplierException {
        long start = System.currentTimeMillis();
        Applier applier = CoreApplier.getInstance().getApplier(CoreApplierType.TOTAL);
        try {
            applier.apply(oldFile, totalFileToFile, newTotalFileToFile);
            Assert.assertTrue(newTotalFileToFile.exists());
            Assert.assertTrue(newTotalFileToFile.length() > 0);
            String md5 = applier.calculateMD5(newTotalFileToFile);
            System.out.println("md5:" + md5);
            Assert.assertNotNull(md5);
        } catch (ApplierException e) {
            e.printStackTrace();
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("testApplyTotalOutToFile time:" + (end - start));
        }
    }

    @Test
    public void testApplyTotalOutToStream() throws ApplierException, FileNotFoundException {
        long start = System.currentTimeMillis();
        Applier applier = CoreApplier.getInstance().getApplier(CoreApplierType.TOTAL);
        try {
            applier.apply(oldFile, new FileInputStream(totalFileToStream), new FileOutputStream(newTotalFileToStream));
            Assert.assertTrue(newTotalFileToStream.exists());
            Assert.assertTrue(newTotalFileToStream.length() > 0);
            String md5 = applier.calculateMD5(newTotalFileToStream);
            System.out.println("md5:" + md5);
            Assert.assertNotNull(md5);
        } catch (ApplierException e) {
            e.printStackTrace();
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("testApplyTotalOutToStream time:" + (end - start));
        }
    }

}

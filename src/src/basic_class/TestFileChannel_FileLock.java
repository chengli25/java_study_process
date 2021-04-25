package basic_class;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author: Zero
 * @Date: 2021/3/21 - 12:56
 * @since: jdk 1.8
 */
public class TestFileChannel_FileLock {
    public void test() throws IOException {
        RandomAccessFile input = new RandomAccessFile("fruit.txt","rw");
        FileChannel channel = input.getChannel();
        FileLock fileLock = channel.tryLock();
        fileLock.release();
    }
}

package com.b2soft.common.log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

public class MDCRequestWrapper extends HttpServletRequestWrapper {

    private byte[] b;

    public MDCRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        InputStream is = super.getInputStream();
        b = IOUtils.toByteArray(is);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bis = new ByteArrayInputStream(b);

        return new ServletImpl(bis);

    }

    public BufferedReader getReaderForMDC() throws IOException {
        final ByteArrayInputStream bis = new ByteArrayInputStream(b);

        return new BufferedReader(new InputStreamReader(new ServletImpl(bis)));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    class ServletImpl extends ServletInputStream {

        private InputStream is;

        public ServletImpl(InputStream bis) {
            is = bis;
        }

        @Override
        public int read() throws IOException {
            return is.read();
        }

        /*
         * (non-Javadoc)
         * @see java.io.InputStream#read(byte[])
         */
        @Override
        public int read(byte[] b) throws IOException {
            return is.read(b);
        }

        /*
         * (non-Javadoc)
         * @see java.io.InputStream#read(byte[])
         */
        @Override
        public boolean isFinished() {
            return false;
        }

        /*
         * (non-Javadoc)
         * @see java.io.InputStream#read(byte[])
         */
        @Override
        public boolean isReady() {
            return false;
        }

        /*
         * (non-Javadoc)
         * @see java.io.InputStream#read(byte[])
         */
        @Override
        public void setReadListener(ReadListener readListener) {
        }
    }
}

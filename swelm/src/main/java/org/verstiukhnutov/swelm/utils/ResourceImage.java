package org.verstiukhnutov.swelm.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceImage {

    private BufferedImage image;

    public ResourceImage(Class<?> resClass, String resourcePath) throws IOException {
        InputStream inputStream = resClass.getResourceAsStream(resourcePath);
        if (inputStream == null)
            throw new IOException("Invalid resource: `"+resourcePath+"`");

        image = ImageIO.read(inputStream);
        if (image == null)
            throw new IOException("Invalid image: `"+resourcePath+"`");
    }

    public ImageIcon toIcon() {
        return new ImageIcon(image);
    }

}

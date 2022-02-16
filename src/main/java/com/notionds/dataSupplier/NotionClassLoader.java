package com.notionds.dataSupplier;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.sun.jdi.ClassLoaderReference;

public class NotionClassLoader<H extends House<H,L>,L extends Library<H,L>,X extends Context<H,L,X>> extends ClassLoaderReference
{


}

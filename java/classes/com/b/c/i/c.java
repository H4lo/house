package com.b.c.i;

import com.b.a.d.f;
import com.b.b.j;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class c
  implements com.b.a.d.d
{
  public void extract(j paramj, com.b.c.d paramd)
  {
    b localb = new b();
    paramd.addDirectory(localb);
    try
    {
      localb.setInt(5, paramj.getUInt16(5));
      localb.setInt(7, paramj.getUInt8(7));
      localb.setInt(8, paramj.getUInt16(8));
      localb.setInt(10, paramj.getUInt16(10));
      localb.setInt(12, paramj.getUInt8(12));
      localb.setInt(13, paramj.getUInt8(13));
      return;
    }
    catch (IOException paramj)
    {
      localb.addError(paramj.getMessage());
    }
  }
  
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.a);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      if ((paramf.length >= "JFIF".length()) && ("JFIF".equals(new String(paramf, 0, "JFIF".length())))) {
        extract(new com.b.b.b(paramf), paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package okhttp3.internal.tls;

import java.security.cert.X509Certificate;

public abstract interface TrustRootIndex
{
  public abstract X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/tls/TrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
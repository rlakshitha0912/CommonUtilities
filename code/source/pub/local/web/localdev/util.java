package pub.local.web.localdev;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
import java.util.concurrent.Executors;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void sleep (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(sleep)>> ---
		// @sigtype java 3.5
		// [i] field:0:required time
		try {
		Long timeInMilliseconds = new IDataMap(pipeline).getAsLong("time", 5000L);
		Thread.sleep(timeInMilliseconds);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void sleepInBackground (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(sleepInBackground)>> ---
		// @sigtype java 3.5
		// [i] field:0:required time
		Executors.newSingleThreadExecutor().execute(()->{
		try {
		Service.doInvoke("pub.local.web.localdev.util", "sleep", pipeline);
		} catch (Exception e) {
		e.printStackTrace();
		}
		});
		// --- <<IS-END>> ---

                
	}
}


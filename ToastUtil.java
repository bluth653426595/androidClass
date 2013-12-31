public class ToastUtil {
    Handler mHandler;
    public ToastUtil() {
        mHandler = new Handler(Looper.getMainLooper());
    }
    class MyRunnable implements Runnable {
        private String contentString = null;
        private int contentId = 0;
        private boolean isString = false;
        public MyRunnable(int contentId) {
            super();
            this.contentId = contentId;
            isString = false;
        }
        public MyRunnable(String contentString) {
            super();
            this.contentString = contentString;
            isString = true;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (isString) {
                Toast.makeText(BobsApplication.getAppContext(), contentString,
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(BobsApplication.getAppContext(), contentId,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void showToast(String content) {
        mHandler.post(new MyRunnable(content));
    }
    public void showToast(int contentId) {
        mHandler.post(new MyRunnable(contentId));
    }
} 
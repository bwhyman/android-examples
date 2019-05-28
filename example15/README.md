# Storage
https://developer.android.google.cn/guide/topics/data/data-storage.html

https://developer.android.google.cn/training/data-storage/files

### Internal Storage
内存储，其他应用无法访问的应用程序的独立空间，使用无需声明权限  
文件随应用删除而删除，空间有限，放应用必须文件  
getFilesDir()/getCacheDir()  
/data/data/packagename/files

### External Storage
外存储私有空间，无需声明权限，随应用卸载删除，放普通文件，缓存文件  
挂载到，/mnt/sdcard/android/data/packname/files  
getExternalFilesDir()/getExternalCacheDir()

外存储公共空间，Android公共目录，音乐，图片等等，需声明权限  
挂载到，/mnt/sdcard/  
Environment.getExternalStoragePublicDirectory()
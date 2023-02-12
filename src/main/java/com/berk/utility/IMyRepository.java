package com.berk.utility;

/**
 * Ilıskısel ya da ılıskısel olmayan tum DB yapılarında kullanılmak uzere genısletılebılır
 * entegre edılebılır bır sıstem kullanmak ıcın bu interface kullanılacaktır.
 * @param <T> Entity için type belirtilir.(Musteri,Product v.s.)
 * @param <ID>Entity içindeki @Id ile belirlenmiş id yi temsıl eder
 *            bu id'nin type girilmelidir.(Long,String)
 */
public interface IMyRepository<T,ID>{
}

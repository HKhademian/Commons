package ir.hossainco.commons.android.room

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update
import io.reactivex.Flowable
import io.reactivex.Single

//@Dao
abstract class CommonDao<ENTITY> {
	//@Query("SELECT * FROM ${ENTITY.TABLE_NAME} WHERE ${ENTITY.TABLE_COL_ID}=:id")
	abstract fun findById(id: String): Flowable<ENTITY>

	//@Query("SELECT * FROM ${ENTITY.TABLE_NAME} WHERE ${ENTITY.TABLE_COL_CODE}=:code")
	//abstract fun findByCodeSync(code: String): Flowable<ENTITY>

	//@Query("SELECT * FROM ${ENTITY.TABLE_NAME}")
	abstract fun list(): Flowable<List<ENTITY>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract fun insertSync(vararg items: ENTITY)

	@Update(onConflict = OnConflictStrategy.REPLACE)
	abstract fun updateSync(vararg item: ENTITY)

	@Delete
	abstract fun deleteSync(vararg item: ENTITY)

//	fun findById(id: String)//: Single<ENTITY>
// =	Single.fromCallable { findByIdSync(id) }
//fun findByCode(code: String)//: Single<ENTITY>
// =	Single.fromCallable { findByCodeSync(code) }
//fun list()//: Observable<ENTITY>
// =	Observable.fromCallable({ listSync() }).flatMap { it -> Observable.fromIterable(it) }

	fun insert(vararg items: ENTITY)//: Single<in Nothing>
		= Single.fromCallable { insertSync(* items) }

	fun update(vararg items: ENTITY)//: Single<in Nothing>
		= Single.fromCallable { updateSync(* items) }

	fun delete(vararg items: ENTITY)//: Single<in Nothing>
		= Single.fromCallable { deleteSync(* items) }
}

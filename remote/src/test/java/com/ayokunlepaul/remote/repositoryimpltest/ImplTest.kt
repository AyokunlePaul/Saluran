package com.ayokunlepaul.remote.repositoryimpltest

import com.ayokunlepaul.data.repository.CategoriesRepository
import com.ayokunlepaul.remote.impl.CategoriesRepositoryImpl
import com.ayokunlepaul.remote.model.CategoryRemoteModel
import com.ayokunlepaul.remote.model.base.BaseRemoteModel
import com.ayokunlepaul.remote.services.SaluranService
import com.ayokunlepaul.remote.utils.JsonUtils
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ImplTest {

    @MockK
    private lateinit var service: SaluranService

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `test that getAllCategories method works as expected`() {
        val data = JsonUtils.parseJson<BaseRemoteModel<CategoryRemoteModel>>("categories.json")
        val repository = mockk<CategoriesRepository>()
        val impl = CategoriesRepositoryImpl(service, repository)
        stubCategoriesResponse(data.data)
        val categories = impl.getAllCategories()
        verify { service.getAllCategories() }
        categories.test().assertComplete().assertValueCount(1).assertValue {
            it.size == data.data.categories.size
        }
    }

    private fun stubCategoriesResponse(data: CategoryRemoteModel) {
        every { service.getAllCategories() } returns Single.just(BaseRemoteModel(data))
    }
}
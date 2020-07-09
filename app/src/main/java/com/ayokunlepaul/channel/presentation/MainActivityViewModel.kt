package com.ayokunlepaul.channel.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ayokunlepaul.channel.mappers.EpisodeMapper
import com.ayokunlepaul.channel.models.SaluranState
import com.ayokunlepaul.channel.utils.SaluranStateUtils
import com.ayokunlepaul.data.interactors.newepisodes.FetchNewEpisodesInteractor

class MainActivityViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val fetchNewEpisodesInteractor: FetchNewEpisodesInteractor,
    private val episodeMapper: EpisodeMapper
) : ViewModel() {

    private val _newEpisodes = MutableLiveData<SaluranState>()
    val newEpisodes: LiveData<SaluranState> get() = _newEpisodes

    fun getNewEpisodes() {
        _newEpisodes.value = SaluranStateUtils.loading()
        fetchNewEpisodesInteractor.executeObservableUseCaseAndPerformAction(
            parameter = null,
            onSuccess = {
                val data = episodeMapper.toModelList(it)
                _newEpisodes.value = SaluranStateUtils.success(data = data)
            },
            onFailure = {
                _newEpisodes.value = SaluranStateUtils.failure(it)
            })
    }

    override fun onCleared() {
        super.onCleared()
        fetchNewEpisodesInteractor.dispose()
    }
}
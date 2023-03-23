package com.example.moviles_systemcolor


import android.media.browse.MediaBrowser
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest.Builder.Companion.fromUri
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaItem.fromUri
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class ReproduccionRemotaFragment : Fragment() {

    private lateinit var player: SimpleExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño del fragmento
        val rootView = inflater.inflate(R.layout.fragment_reproduccion_remota, container, false)

        // Obtiene el PlayerView del diseño inflado
        val playerView = rootView.findViewById<PlayerView>(R.id.player_view)

        // Crea un SimpleExoPlayer
        player = SimpleExoPlayer.Builder(requireContext()).build()

        // Asigna el SimpleExoPlayer al PlayerView
        playerView.player = player

        // Crea una instancia de MediaItem con la URL del contenido remoto
        val mediaItem: MediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

        // Crea un MediaSource a partir del MediaItem
        val mediaSource = ProgressiveMediaSource.Factory(DefaultDataSourceFactory(requireContext()))
            .createMediaSource(mediaItem)

        // Prepara el reproductor con el MediaSource
        player.prepare(mediaSource)

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Libera los recursos del SimpleExoPlayer cuando se destruye la vista
        player.release()
    }
}
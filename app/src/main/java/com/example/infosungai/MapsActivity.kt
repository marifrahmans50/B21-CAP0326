package com.example.infosungai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private lateinit var mMap: GoogleMap
    var arrList = ArrayList<MapValue>()
    var arrList1 = ArrayList<Result>()
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var gridListAdaptor: MapsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        recyclerView = findViewById(R.id.recycler_view_home)

        var gson = Gson()
        var theater: MapValue = gson.fromJson(Utils.getAssetJsonData(this), MapValue::class.java)
        arrList.add(theater)

        for (i in 0 until arrList.get(0).results.size) {
            arrList1.add(arrList.get(0).results.get(i))
        }

        gridLayoutManager =
                GridLayoutManager(applicationContext, 1, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        gridListAdaptor = MapsAdapter(applicationContext, arrList1!!)
        recyclerView?.adapter = gridListAdaptor

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }




    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        /*mMap.setOnMarkerClickListener { marker ->
            if (marker.isInfoWindowShown) {
                marker.hideInfoWindow()
            } else {
                marker.showInfoWindow()
            }
            true
        }

         */

        for (i in 0 until arrList1.size) {
            val place =
                    LatLng(arrList1.get(i).lintang_selatan, arrList1.get(i).bujur_timur)
            mMap.addMarker(MarkerOptions()
                    .position(place)
                    .title("" + arrList1.get(i).nama_sungai)
                    .snippet("Indeks Pencemaran:" + arrList1.get(i).indeks_pencemar + "\n" + arrList1.get(i).kategori))
            //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_baseline_movie_24))

            mMap.moveCamera(CameraUpdateFactory.newLatLng(place))

        }

        mMap.maxZoomLevel
        googleMap.setOnInfoWindowClickListener(this)
        mMap.setInfoWindowAdapter(CustomInfoWindow(this))
    }
    override fun onInfoWindowClick(marker: Marker) {
        /*
            val moveActivity = Intent(this, DetailActivity::class.java)
            //moveActivity.putExtra(HalamanDetail.EXTRA_PERSON, data)
            intent.putExtra("name", data.name)
            intent.putExtra("description", data.rating)
            intent.putExtra("imageUrl", data.scope)
            startActivity(moveActivity)


         */


        //val moveActivity = Intent(this@MapsActivity, DetailActivity::class.java)
        //moveActivity.putExtra(DetailActivity.EXTRA_PERSON, marker)
        //intent.putExtra("name", marker)
        // intent.putExtra("description", arrList1.get(i).rating)
        // intent.putExtra("imageUrl", arrList1.get(i).scope)


        //startActivity(moveActivity)






        /*val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)

         */


        Toast.makeText(
                this, "Info window clicked",
                Toast.LENGTH_SHORT
        ).show()






    }

}

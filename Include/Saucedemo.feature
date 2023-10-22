Feature: Saucedemo
  user login ke saucedemo.com
  
  @login  @report
  Scenario: User login kedalam web
    Given User berada dihalaman login
    When User masukkan username
    And User masukkan password
    And User menekan tombol login
    Then User berada di halaman home web
 
 	@loginNegative  @report
 	Scenario: User menggunakan credentials yang salah
 	  Given User berada dihalaman login
    When User masukkan username yang salah
    And User masukkan password yang salah
    And User menekan tombol login
    Then User tidak bisa login
    
	@pesanBarang  @report
	Scenario: User memesan barang
		Given User berada di homepage
		When User masukkan barang ke keranjang
		And User menekan tombol keranjang
		And User menekan tombol checkout
		And User memasukkan data pemesan
		And User menekan tombol continue
		And User menekan tombol finish
		Then User berhasil memesan
		
	@hapusBarang  @report
	Scenario: User menghapus barang di keranjang
		Given User berada di homepage
		When User masukkan barang ke keranjang
		And User menekan tombol keranjang
		And User menekan tombol remove
		Then User berhasil hapus barang
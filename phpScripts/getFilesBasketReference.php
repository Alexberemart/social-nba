<?php
$ch = curl_init();

curl_setopt($ch, CURLOPT_URL, "http://www.basketball-reference.com/leagues/NBA_2016_games.html");
curl_setopt($ch, CURLOPT_HEADER, 0);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);

//should save html in $html
$html = curl_exec($ch);
curl_close($ch);
$ch = curl_init();
echo "cojo HTML";

curl_setopt($ch, CURLOPT_URL, "http://socialnba-alexberemart.rhcloud.com/socialNBA/rest/basketReference/files");
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $html);

// receive server response ...
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

echo "envio petición";

$server_output = curl_exec($ch);
$server_output_array = json_decode($server_output);

echo "respuesta servidor".$server_output;
echo "respuesta servidor" . count($server_output_array);

// Comprobar si ocurrió un error
if (!curl_errno($ch)) {
    $info = curl_getinfo($ch);

    echo 'Se tardó ' . $info['total_time'] . ' segundos en enviar la petición a ' . $info['url'];
    echo 'Respuesta ' . $info['http_code'];
}
curl_close($ch);

foreach ($server_output_array as $item) {
    $fileName = substr($item, 11);
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "http://www.basketball-reference.com" . $item);
    curl_setopt($ch, CURLOPT_HEADER, 0);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);

    $html = curl_exec($ch);
    curl_close($ch);
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "http://socialnba-alexberemart.rhcloud.com/socialNBA/rest/basketReference/files2/" . $fileName);
    echo "http://socialnba-alexberemart.rhcloud.com/socialNBA/rest/basketReference/files2/" . $fileName."<BR>";
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $html);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);
    curl_close($ch);
}

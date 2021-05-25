<?php

    $host = 'localhost';
    $user = 'root';
    $password = '';
    $database = 'cinema';

    $connection = mysqli_connect($host, $user, $password, $database);

    if(!$connection){
        die("Connection Error in Connecting " . $mysqli_connect_error());
    }

    $response = array();
    
    $sql_query = "select * from movies";
    $res = mysqli_query($connection, $sql_query);

    if(mysqli_num_rows($res) > 0){
        while($row = mysqli_fetch_assoc($res)){
            array_push($response, $row);
        }
    }

    else{
        $response['message'] = 'No Data Found!';
    }

    echo json_encode($response);
    mysqli_close($connection);

?>
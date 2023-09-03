import { useState } from "react"

export const userPresenterMock = () => {

    const res = {
        user : {
            "idUser": 1,
            "name": "testname",
            "lastName": "testlastName",
            "dni": "33555444",
            "email": "user@gmail.com",
            "username": "userTest",
            "password": "1234"
          }
    }

    const getMock = () => {
        return res   
    }

    return {
        getMock
    }
}
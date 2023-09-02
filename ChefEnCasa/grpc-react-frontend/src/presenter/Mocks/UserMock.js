import { useState } from "react"

export const userPresenterMock = () => {

    const res = {
        user : {
            idUser: 1,
            userName: 'lucasambesi',
        }
    }
    
    const getByIdMock = () => {
        return res   
    }

    const getMock = () => {
        return res   
    }

    return {
        getByIdMock,
        getMock
    }
}
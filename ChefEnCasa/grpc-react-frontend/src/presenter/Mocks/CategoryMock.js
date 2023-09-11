export const categoryPresenterMock = () => {

    const res = {
        category : {
            idCategory: 1,
            name: 'comidas',
        },
        categories: [
            {
                idCategory: 1,
                name: 'comidas',
            },
            {
                idCategory: 2,
                name: 'postres',
            },
        ]
    }
    
    const getMock = () => {
        return res   
    }

    return {
        getMock,
    }
}
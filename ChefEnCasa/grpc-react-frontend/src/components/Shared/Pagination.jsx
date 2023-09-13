import * as React from 'react';
import Typography from '@mui/material/Typography';
import Pagination from '@mui/material/Pagination';
import Stack from '@mui/material/Stack';
import {recipePresenter} from '../../presenter/RecipePresenter'

export default function PaginationControlled(props) {
  
  const { filter, setFilter, setRecipes } = props
  const [page, setPage] = React.useState(filter.pageNumber);
  const {getByFilter} = recipePresenter()

  const  handleChange = async (event, value) => {
    setPage(value)

    let tempFilter = { ...filter }
    tempFilter["pageNumber"] = value
    setFilter(tempFilter)

    let res = await getByFilter(tempFilter)
    setRecipes(res)
    
}

  return (
    <Stack spacing={2}>
      <Pagination count={10} page={page} onChange={handleChange} />
    </Stack>
  );
}
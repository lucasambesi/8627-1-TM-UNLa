import * as React from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import { Button, Stack } from '@mui/material';
import { useNavigate } from 'react-router'

Row.propTypes = {
    row: PropTypes.shape({
      calories: PropTypes.number.isRequired,
      carbs: PropTypes.number.isRequired,
      fat: PropTypes.number.isRequired,
      history: PropTypes.arrayOf(
        PropTypes.shape({
          amount: PropTypes.number.isRequired,
          customerId: PropTypes.string.isRequired,
          date: PropTypes.string.isRequired,
        }),
      ).isRequired,
      name: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
      protein: PropTypes.number.isRequired,
    }).isRequired,
  };
  
  function Row(props) {
    const { row } = props;
    const [open, setOpen] = React.useState(false);

    const navigate = useNavigate();

    const handleDetalles = (recipe) => {
      navigate(`/recipe/${recipe.IdRecipe}`)
    };
  
    return (
      <React.Fragment>
        <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
          <TableCell>
            <Stack spacing={1} direction={"row"} alignItems={"center"} justifyContent={"start"}>
                <IconButton
                aria-label="expand row"
                size="small"
                onClick={() => setOpen(!open)}
                >
                {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
                </IconButton>
                <Typography variant="body1" gutterBottom component="body1">
                    {row.Name}
                </Typography>
                <Typography variant="body2" gutterBottom component="body2">
                    {
                        row.Recipes 
                        ? 
                        `(Hay ${row.Recipes.Recipe.length} recetas agregadas)` 
                        :
                        null
                    }
                </Typography>
            </Stack>            
          </TableCell>
          <TableCell />
          <TableCell align="right">
            <Button variant="outlined">
                Eliminar
            </Button>
          </TableCell>
        </TableRow>
        <TableRow>
            <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                {
                row.Recipes
                ?
                    <Box sx={{ margin: 1 }}>
                        <Typography variant="h6" gutterBottom component="div">
                            Recetas
                        </Typography>
                        <Table size="small" aria-label="purchases">
                        <TableHead>
                            <TableRow>
                            <TableCell />
                            <TableCell align="right" />
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                            row.Recipes.Recipe
                            ?
                            row.Recipes.Recipe.map((recipe) => (
                            <TableRow key={recipe.IdRecipe}>
                                <TableCell component="th" scope="row">
                                {recipe.Title}
                                </TableCell>
                                <TableCell align="right">
                                    <Button variant="outlined" size='small' onClick={(() => handleDetalles(recipe))}>
                                        Ver detalles
                                    </Button>
                                </TableCell>
                            </TableRow>
                            ))
                            :
                            null
                            }
                        </TableBody>
                        </Table>
                    </Box>
                    :
                    <Box sx={{ margin: 1 }}>
                        <Typography variant="body2" gutterBottom component="div" align='center'>
                            No hay recetas para ver
                        </Typography>
                    </Box>
                } 
                </Collapse>
            </TableCell>
        </TableRow>
      </React.Fragment>
    );
  }

export const BooksTable = (props) => {

  const { books } = props

  return (
    <TableContainer component={Paper}>
      <Table aria-label="collapsible table">
        <TableHead>
          <TableRow>
            <TableCell>
                <Typography variant="h6" gutterBottom component="div">
                  Recetarios
                </Typography>
            </TableCell>
            <TableCell />
            <TableCell />
          </TableRow>
        </TableHead>
        <TableBody>
          {
            books ? books.map((book) => (
                <Row key={book.Name} row={book} />
            ))
            :
            null
          }
        </TableBody>
      </Table>
    </TableContainer>
  );
}